package com.language.web;

import com.language.Service.LanguageService;
import com.language.domain.CurrentLanguage;
import com.language.domain.Language;
import com.language.domain.LanguageCreateForm;
import com.language.domain.validator.LanguageCreateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by user on 21.12.15.
 */

@Controller
public class LanguageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);

    protected static final String PATH_ROOT = "/languages";
    protected static final String PATH_CREATE = "/language/create";
    protected static final String PATH_SAVE = "/languages/save";
    protected static final String PATH_GET = "/languages/get/{languageId}";
    protected static final String PATH_DELETE = "/languages/delete/{languageId}";


    @Autowired
    private LanguageService languageService;

    @Autowired
    private LanguageCreateFormValidator languageCreateFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(languageCreateFormValidator);
    }



    @RequestMapping(value = PATH_CREATE, method = RequestMethod.GET)
    public String getLanguageCreatePage(Model model) {
        LOGGER.debug("Getting language create form");
        model.addAttribute("form", new LanguageCreateForm());
        return "languageCreate";
    }



    @RequestMapping(value = PATH_CREATE, method = RequestMethod.POST)
    public String handleLanguageCreateForm(@Valid @ModelAttribute("form") LanguageCreateForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "languageCreate";
        }
        try {
            Language language = languageService.create(form);
            CurrentLanguage currentLanguage = new CurrentLanguage(language);

        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the language, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "languageCreate";
        }
        return "redirect:/";
    }

    @RequestMapping(PATH_ROOT)
    @Secured("ROLE_ADMIN")
    public String getlanguages(Model model) {
        LOGGER.debug("Getting languages list");
        model.addAttribute("language", new Language());
        model.addAttribute("languages", languageService.getAllLanguages());
        return "languages";
    }

    @RequestMapping(value = PATH_SAVE, method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String saveLanguage(@Valid @ModelAttribute("language") Language language, BindingResult bindingResult) {
        LOGGER.debug("Getting save language action");
        if (bindingResult.hasErrors()) {
            return "languageForm";
        }
        languageService.save(language);
        return "redirect:/languages";
    }

    @RequestMapping(PATH_GET)
    @Secured("ROLE_ADMIN")
    public String getLanguage(@PathVariable("languageId") Long languageId, Model model) {
        LOGGER.debug("Getting get language action" + languageId);
        Language language = languageService.getLanguageById(languageId);
        model.addAttribute("language", language);

        return "languageForm";
    }

    @RequestMapping(value = PATH_DELETE, method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteLanguage(@PathVariable("languageId") Long languageId) {
        LOGGER.debug("Delete language by id action");
        Language language = languageService.getLanguageById(languageId);
        languageService.delete(language);
        return "redirect:/languages";
    }
}
