package com.language.domain.validator;


import com.language.Service.WordService;
import com.language.domain.UserCreateForm;
import com.language.domain.WordCreateForm;
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
public class WordCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordCreateFormValidator.class);

    @Autowired
    private WordService wordService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(WordCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        WordCreateForm form = (WordCreateForm) target;

    }


}
