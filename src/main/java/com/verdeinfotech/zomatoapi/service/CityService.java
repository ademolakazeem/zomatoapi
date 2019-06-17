package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.LocationSuggestions;
import org.springframework.http.ResponseEntity;


public interface CityService {
    ResponseEntity<LocationSuggestions> getCity(String city);
}
