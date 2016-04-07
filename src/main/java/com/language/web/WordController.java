package com.language.web;


import com.language.Service.WordService;
import com.language.domain.*;

import com.language.domain.validator.WordCreateFormValidator;
import com.language.repository.LanguageRepository;
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
 * Created by user on 20.12.15.
 */


@Controller
public class WordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordController.class);

    protected static final String PATH_ROOT = "/words";
    protected static final String PATH_CREATE = "/word/create";
    protected static final String PATH_SAVE = "/words/save";
    protected static final String PATH_GET = "/words/get/{wordId}";
    protected static final String PATH_DELETE = "/words/delete/{wordId}";

    @Autowired
    private WordService wordService;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private WordCreateFormValidator wordCreateFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(wordCreateFormValidator);
    }

    @RequestMapping(value = PATH_CREATE, method = RequestMethod.GET)
    public String getWordCreatePage(Model model) {
        LOGGER.debug("Getting word create form");
        model.addAttribute("form", new WordCreateForm());
        return "wordCreate";
    }


    @RequestMapping(value = PATH_CREATE, method = RequestMethod.POST)
    public String handleWordCreateForm(@Valid @ModelAttribute("form") WordCreateForm form, BindingResult bindingResult) {

        LOGGER.debug("Processing word create form={}, bindingResult={}", form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "wordCreate";
        }
        try {
            Word word = wordService.create(form);
            CurrentWord currentword = new CurrentWord(word);

        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "wordCreate";
        }
        return "redirect:/";
    }


    @RequestMapping(PATH_ROOT)
    public String getWords(Model model) {
        LOGGER.debug("Getting words list");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        if (currentUser.getRole().equals(Role.ROLE_ADMIN)){
            model.addAttribute("word", new Word());
            model.addAttribute("words", wordService.getAllWords());
        } else {
            model.addAttribute("word", new Word());
            model.addAttribute("words", wordService.getWordsByUser(currentUser.getUser()));
        }

        return "words";
    }

    @RequestMapping(value = PATH_SAVE, method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String saveWord(@Valid @ModelAttribute("word") Word word, BindingResult bindingResult) {
        LOGGER.debug("Getting save word action");
        if (bindingResult.hasErrors()) {
            return "wordForm";
        }
        wordService.save(word);
        return "redirect:/words";
    }

    @RequestMapping(PATH_GET)
    @Secured("ROLE_ADMIN")
    public String getWord(@PathVariable("wordId") Long wordId, Model model) {
        LOGGER.debug("Getting get word action" + wordId);
        Word word = wordService.getWordById(wordId);
        model.addAttribute("word", word);
        model.addAttribute("languages", languageRepository.findAll());
        return "wordForm";
    }

    @RequestMapping(value = PATH_DELETE, method = RequestMethod.POST)
    @Secured("ROLE_ADMIN")
    public String deleteWord(@PathVariable("wordId") Long wordId) {
        LOGGER.debug("Delete word by id action");
        Word word = wordService.getWordById(wordId);
        wordService.delete(word);
        return "redirect:/words";
    }


}