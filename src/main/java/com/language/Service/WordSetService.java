package com.language.Service;

import com.language.domain.WordSet;
import com.language.domain.WordSetCreateForm;

import java.util.List;

/**
 * Created by user on 17.12.15.
 */
public interface WordSetService {

    void delete(WordSet wordSets);

    List<WordSet> findByUserId(Long id);

    WordSet save(WordSet wordSets);

    WordSet create(WordSetCreateForm form);

    List<WordSet> getAllWordSets();

    WordSet getWordSetById(Long id);

}
