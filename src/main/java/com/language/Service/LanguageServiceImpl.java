package com.language.Service;

import com.language.domain.Language;
import com.language.domain.LanguageCreateForm;
import com.language.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.12.15.
 */

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{
    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Autowired
    private LanguageRepository languageRepository;

    /*
    @Override
    public List<Languages> findByUsersId(List<Long> usersId) {
        LOGGER.debug("Getting language by usersIdList");
        return languagesRepository.findByUsersIdIn(usersId);
    }
    */

    @Override
    public Language findById(Long id) {
        LOGGER.debug("Getting language={}\", id");
        return languageRepository.findOne(id);
    }

    @Override
    public List<Language> getAllLanguages() {
        LOGGER.debug("Getting all languages");
        List<Language> languages = new ArrayList<Language>();
        for (Language language : languageRepository.findAll()) {
            languages.add(language);
        }
        return languages;
    }

    @Override
    public Language getLanguageById(Long id) {
        LOGGER.debug("Getting language={}", id);
        return languageRepository.findOne(id);
    }

    @Override
    public Language create(LanguageCreateForm form) {
        LOGGER.debug("Create new language");
        Language language = new Language();
        language.setName(form.getName());
        language.setDescription(form.getDescription());

        return languageRepository.save(language);
    }

    @Override
    public Language save(Language language) {
        LOGGER.debug("Saving language={}\", language");
        return languageRepository.save(language);
    }

    @Override
    public void delete(Language language) {
        LOGGER.debug("Deleting language={}\", language");
        languageRepository.delete(language);
    }
}
