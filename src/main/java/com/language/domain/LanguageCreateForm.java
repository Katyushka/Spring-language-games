package com.language.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by user on 21.12.15.
 */
public class LanguageCreateForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
