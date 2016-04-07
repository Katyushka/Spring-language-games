package com.language.domain;

/**
 * Created by user on 21.12.15.
 */
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentWord {

    private Word word;

    public CurrentWord(Word word) {

        this.word = word;
    }


}
