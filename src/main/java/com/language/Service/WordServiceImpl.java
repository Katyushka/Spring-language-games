package com.language.Service;

import com.language.domain.User;
import com.language.domain.Word;
import com.language.domain.WordCreateForm;
import com.language.domain.WordSet;
import com.language.repository.WordRepository;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 20.12.15.
 */

@Service
@Transactional
public class WordServiceImpl implements WordService {


    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Word> getAllWords() {
        LOGGER.debug("Getting all users");
        List<Word> users = new ArrayList<Word>();
        for (Word word : wordRepository.findAll()) {
            users.add(word);
        }
        return users;
    }

    @Override
    public List<Word> getWordsByUser(User user) {
        user = userService.getUserById(user.getId());
        List<Word> words = new ArrayList<>();
        Hibernate.initialize(user.getWordSets());
        for (WordSet wordSet : user.getWordSets()) {
            Hibernate.initialize(wordSet.getWordsList());
            words.addAll(wordSet.getWordsList());
        }
        return words;
    }

    @Override
    public Word getWordById(Long id) {
        LOGGER.debug("Getting word={}", id);
        return wordRepository.findOne(id);
    }


    @Override
    public Word create(WordCreateForm form) {
        LOGGER.debug("Create new user");
        Word word = new Word();
        word.setContent(form.getContent());
        return wordRepository.save(word);
    }

    @Override
    public Word save(Word word) {
        LOGGER.debug("Saving word={}\", word");
        return wordRepository.save(word);
    }

    @Override
    public void delete(Word word) {
        LOGGER.debug("Deleting word={}\", word");
        wordRepository.delete(word);
    }
}
