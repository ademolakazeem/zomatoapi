package com.verdeinfotech.zomatoapi.controller;

import com.verdeinfotech.zomatoapi.model.Categories;
import com.verdeinfotech.zomatoapi.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Categories> getCategories() {
        ResponseEntity<Categories> responseEntity = categoryService.getCategories();
        if (responseEntity != null) {
            LOGGER.info("response: " + responseEntity.getBody());
            return ResponseEntity.ok().body(responseEntity.getBody());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
