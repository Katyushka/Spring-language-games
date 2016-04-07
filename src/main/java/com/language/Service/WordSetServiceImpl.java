package com.language.Service;

import com.language.domain.WordSet;
import com.language.domain.WordSetCreateForm;
import com.language.repository.WordSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.12.15.
 */
@Service
@Transactional
public class WordSetServiceImpl implements WordSetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Autowired
    private WordSetRepository wordSetRepository;

    @Override
    public void delete(WordSet wordSet) {
        LOGGER.debug("Deleting wordSet={}\", wordSets");
        wordSetRepository.delete(wordSet);
    }


    @Override
    public List<WordSet> findByUserId(Long id) {
        LOGGER.debug("Getting wordSets by userId");
        return wordSetRepository.findByUserId(id);
    }

    @Override
    public WordSet save(WordSet wordSets) {
        LOGGER.debug("Saving wordSet={}\", wordSets");
        return wordSetRepository.save(wordSets);
    }

    @Override
    public WordSet create(WordSetCreateForm form) {
        LOGGER.debug("Create new word set");
        WordSet wordSet = new WordSet();
        wordSet.setName(form.getName());
        wordSet.setDescription(form.getDescription());

        return wordSetRepository.save(wordSet);
    }

    @Override
    public List<WordSet> getAllWordSets() {
        LOGGER.debug("Getting all word sets");
        List<WordSet> wordSets = new ArrayList<WordSet>();
        for (WordSet wordSet : wordSetRepository.findAll()) {
            wordSets.add(wordSet);
        }
        return wordSets;
    }

    @Override
    public WordSet getWordSetById(Long id) {
        LOGGER.debug("Getting word set={}", id);
        return wordSetRepository.findOne(id);
    }
}
