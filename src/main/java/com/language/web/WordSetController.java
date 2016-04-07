package com.language.web;

import com.language.Service.WordSetService;
import com.language.domain.*;
import com.language.domain.validator.WordSetCreateFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;
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
public class WordSetController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordSetController.class);

    protected static final String PATH_ROOT = "/wordSets";
    protected static final String PATH_CREATE = "/wordSet/create";
    protected static final String PATH_SAVE = "/wordSets/save";
    protected static final String PATH_GET = "/wordSets/get/{wordSetId}";
    protected static final String PATH_DELETE = "/wordSets/delete/{wordSetId}";


    @Autowired
    private WordSetService wordSetService;

    @Autowired
    private WordSetCreateFormValidator wordSetCreateFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(wordSetCreateFormValidator);
    }

    @RequestMapping(value = PATH_CREATE, method = RequestMethod.GET)
    public String getWordSetCreatePage(Model model) {
        LOGGER.debug("Getting word set create form");
        model.addAttribute("form", new WordSetCreateForm());
        return "wordSetCreate";
    }

    @RequestMapping(value = PATH_CREATE, method = RequestMethod.POST)
    public String handleWordSetCreateForm(@Valid @ModelAttribute("form") WordSetCreateForm form, BindingResult bindingResult) {

        LOGGER.debug("Processing word set create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "wordSetCreate";
        }
        try {
            WordSet wordSet = wordSetService.create(form);

        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "wordSetCreate";
        }
        return "redirect:/";
    }


    @RequestMapping(PATH_ROOT)
    public String getWordSets(Model model) {
        LOGGER.debug("Getting word sets list");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        if (currentUser.getRole().equals(Role.ROLE_ADMIN)){
            model.addAttribute("wordSet", new WordSet());
            model.addAttribute("wordSets", wordSetService.getAllWordSets());
        } else {
            model.addAttribute("wordSet", new WordSet());
            model.addAttribute("wordSets", wordSetService.findByUserId(currentUser.getId()));
        }
        return "wordSets";
    }




    @RequestMapping(value = PATH_SAVE, method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String saveWordSet(@Valid @ModelAttribute("wordSet") WordSet wordSet, BindingResult bindingResult) {
        LOGGER.debug("Getting save word set action");
        if (bindingResult.hasErrors()) {
            return "wordSetForm";
        }
        wordSetService.save(wordSet);
        return "redirect:/wordSets";
    }

    @RequestMapping(PATH_GET)
    @Secured("ROLE_ADMIN")
    public String getWordSet(@PathVariable("wordSetId") Long wordSetId, Model model) {
        LOGGER.debug("Getting get word set action" + wordSetId);
        WordSet wordSet = wordSetService.getWordSetById(wordSetId);
        model.addAttribute("wordSet", wordSet);
        return "wordSetForm";
    }


    @RequestMapping(value = PATH_DELETE, method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteWordSet(@PathVariable("wordSetId") Long wordSetId) {
        LOGGER.debug("Delete word set by id action");
        WordSet wordSet = wordSetService.getWordSetById(wordSetId);
        wordSetService.delete(wordSet);
        return "redirect:/wordSets";
    }


}
