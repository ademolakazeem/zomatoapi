package com.verdeinfotech.zomatoapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FirstCategories {
    @JsonProperty("categories")
    private List<SecondCategories> secondCategories;

    public List<SecondCategories> getSecondCategories() {
        return secondCategories;
    }

    public void setSecondCategories(List<SecondCategories> secondCategories) {
        this.secondCategories = secondCategories;
    }
}
