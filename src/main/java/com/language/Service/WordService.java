package com.language.Service;

import com.language.domain.User;
import com.language.domain.Word;
import com.language.domain.WordCreateForm;

import java.util.List;

/**
 * Created by user on 17.12.15.
 */
public interface WordService {
    List<Word> getAllWords();
    List<Word> getWordsByUser(User user);
    Word getWordById(Long id);
    Word create(WordCreateForm form);
    Word save(Word word);
    void delete(Word word);
}
