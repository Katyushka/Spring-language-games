package com.language.domain.validator;

import com.language.Service.LanguageService;
import com.language.domain.Language;
import com.language.domain.LanguageCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

/**
 * Created by user on 21.12.15.
 */
@Component
public class LanguageCreateFormValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageCreateFormValidator.class);

    @Autowired
    private LanguageService languageService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(LanguageCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        LanguageCreateForm form = (LanguageCreateForm) target;

    }

}
