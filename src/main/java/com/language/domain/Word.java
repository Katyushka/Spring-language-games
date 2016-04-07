package com.language.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 12.12.15.
 */

@Entity
@Table(name = "words")
public class Word implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private  Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="languageId", nullable = false)
    private Language language;

    @ManyToMany(mappedBy="wordsList")
    private List<WordSet> wordSets;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "word_to_word",
            joinColumns = {@JoinColumn(name = "first_word_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "second_word_id", referencedColumnName = "id")})
    private List<Word> translateList;


    public List<Word> getTranslateList() {
        return translateList;
    }

    public void setTranslateList(List<Word> translateList) {
        this.translateList = translateList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Language getLanguages() {
        return language;
    }

    public void setLanguages(Language languages) {
        this.language = languages;
    }

    public List<WordSet> getWordSets() {
        return wordSets;
    }

    public void setWordSets(List<WordSet> wordSets) {
        this.wordSets = wordSets;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
