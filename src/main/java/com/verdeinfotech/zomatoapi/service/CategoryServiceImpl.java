package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.Categories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    RestTemplate restTemplate = new RestTemplate();
    @Value("${endpoint-url}")
    private String zomatoUrl;

    @Override
    public ResponseEntity<Categories> getCategories() {
        ResponseEntity<Categories> categoryResponseEntity = null;
        final String url = zomatoUrl + "/categories";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("user-key", "1913682cf50e7942ce8c1b3748e8172f");
        HttpEntity entity = new HttpEntity(headers);
        try {
            LOGGER.info("Url:" + url);
            LOGGER.info("Before service:" + entity.getHeaders().toString());
            categoryResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Categories>() {
                    });
            LOGGER.info("In service:" + categoryResponseEntity.getBody());
        } catch (Exception ex) {
            LOGGER.info(String.valueOf(ex));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return categoryResponseEntity;
    }
}
