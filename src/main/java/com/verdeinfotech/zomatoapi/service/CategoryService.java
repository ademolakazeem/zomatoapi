package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.Categories;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<Categories> getCategories();
}
