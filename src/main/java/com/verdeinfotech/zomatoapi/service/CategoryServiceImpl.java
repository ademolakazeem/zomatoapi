package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.Category;
import com.verdeinfotech.zomatoapi.model.FirstCategories;
import com.verdeinfotech.zomatoapi.model.SecondCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    RestTemplate restTemplate = new RestTemplate();
    @Value("${endpoint-url}")
    private String zomatoUrl;

    @Override
    public ResponseEntity<FirstCategories> getCategories() {
        ResponseEntity<FirstCategories> categoryResponseEntity = null;
        ResponseEntity<FirstCategories> newResponseEntity = null;
        List<Category> categoryList = null;
        Category cat = null;


        final String url = zomatoUrl + "/categories";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("user-key", "1913682cf50e7942ce8c1b3748e8172f");
        HttpEntity entity = new HttpEntity(headers);
        try {

            LOGGER.info("Url:" + url);
            LOGGER.info("Before service:" + entity.getHeaders().toString());
            categoryResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<FirstCategories>() {
                    });

            LOGGER.info("In service:" + categoryResponseEntity.getBody().getSecondCategories());
            for (SecondCategories secondCategories : categoryResponseEntity.getBody().getSecondCategories()) {
                if (secondCategories.getCategory().getId() >= 3 && secondCategories.getCategory().getId() <= 6) {
                    LOGGER.info("ID=:" + secondCategories.getCategory().getId() + " Name=:" + secondCategories.getCategory().getName());
                }

            }


        } catch (Exception ex) {
            LOGGER.info(String.valueOf(ex));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        List<SecondCategories> catG = categoryResponseEntity.getBody().getSecondCategories()
                .stream()
                .filter(catLine -> catLine.getCategory().getId() >= 3)
                .filter(catId -> catId.getCategory().getId() <= 10)
                .collect(Collectors.toList());
        FirstCategories fc = new FirstCategories();
        fc.setSecondCategories(catG);
        return ResponseEntity.ok().body(fc);
    }


}
