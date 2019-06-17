package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class CityServiceImpl implements CityService{

    RestTemplate restTemplate = new RestTemplate();
    @Value("${endpoint-url}")
    private String zomatoUrl;

    @Override
    public ResponseEntity<Object> getCity(String city) {
        final String url = zomatoUrl + "/cities?q=" + city;
        ResponseEntity<Object> responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //headers.set("user-key", "1913682cf50e7942ce8c1b3748e8172f");
        HttpEntity entity = new HttpEntity(headers);
        try {
            System.out.println("Url:" + url);
            System.out.println("Before service:" + entity.getHeaders().get(0).toString());
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                    Object.class);
            System.out.println("In service:" + responseEntity.getBody());
        }
        catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return responseEntity;
    }
}
