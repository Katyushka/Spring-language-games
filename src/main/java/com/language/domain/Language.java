package com.language.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12.12.15.
 */

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private  Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
    private List<WordSet> wordSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
    private List<Word> wordList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WordSet> getWordSet() {
        return wordSet;
    }

    public void setWordSet(List<WordSet> wordSet) {
        this.wordSet = wordSet;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return name;
    }

    public void setEmail(String email) {
        this.name = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WordSet> getWordSets() {
        return wordSet;
    }

    public void setWordSets(List<WordSet> wordSets) {
        this.wordSet = wordSet;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void setWordsList(List<Word> wordList) {
        this.wordList = wordList;
    }
}
