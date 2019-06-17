package com.verdeinfotech.zomatoapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OuterCategories {
    @JsonProperty("categories")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
