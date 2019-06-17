package com.verdeinfotech.zomatoapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Categories {
    @JsonProperty("categories")
    private List<OuterCategories> outerCategories;

    public List<OuterCategories> getOuterCategories() {
        return outerCategories;
    }

    public void setOuterCategories(List<OuterCategories> outerCategories) {
        this.outerCategories = outerCategories;
    }
}
