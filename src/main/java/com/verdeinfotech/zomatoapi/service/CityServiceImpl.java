package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.LocationSuggestions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    RestTemplate restTemplate = new RestTemplate();
    @Value("${endpoint-url}")
    private String zomatoUrl;

    @Override
    public ResponseEntity<LocationSuggestions> getCity(String city) {
        final String url = zomatoUrl + "/cities?q=" + city;
        ResponseEntity<LocationSuggestions> responseEntity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("user-key", "1913682cf50e7942ce8c1b3748e8172f");
        HttpEntity entity = new HttpEntity(headers);
        try {
            LOGGER.info("Url:" + url);
            LOGGER.info("Before service:" + entity.getHeaders().toString());
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<LocationSuggestions>() {
                    });
            LOGGER.info("After Service:" + responseEntity.getBody());
        } catch (Exception exception) {
            LOGGER.info(String.valueOf(exception));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return responseEntity;
    }
}
