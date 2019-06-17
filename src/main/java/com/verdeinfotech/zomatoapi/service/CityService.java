package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.City;
import org.springframework.http.ResponseEntity;


import java.util.List;


public interface CityService {
ResponseEntity<Object> getCity(String city);
}
