package com.verdeinfotech.zomatoapi.service;

import com.verdeinfotech.zomatoapi.model.FirstCategories;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<FirstCategories> getCategories();
}
