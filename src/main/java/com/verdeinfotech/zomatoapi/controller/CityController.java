package com.verdeinfotech.zomatoapi.controller;

import com.verdeinfotech.zomatoapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public ResponseEntity<Object> getCities(@RequestParam("q") String city){
        ResponseEntity<Object> responseEntity = cityService.getCity(city);
        if (responseEntity != null) {
            System.out.println("response: "+ responseEntity.getBody());
            return ResponseEntity.ok().body(responseEntity.getBody());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
