package com.verdeinfotech.zomatoapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LocationSuggestions {
    @JsonProperty("location_suggestions")
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
