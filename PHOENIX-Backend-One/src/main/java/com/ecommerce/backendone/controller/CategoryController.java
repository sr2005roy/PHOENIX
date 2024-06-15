package com.ecommerce.backendone.controller;

import com.ecommerce.backendone.entity.Category;
import com.ecommerce.backendone.entity.Product;
import com.ecommerce.backendone.service.CategoryService;
import com.ecommerce.backendone.utility.MappingJacksonValueBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
 
@RestController
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/{id}")
    public MappingJacksonValue getCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        return MappingJacksonValueBuilder.init(category)
                .addFilter(Category.FILTER)
                .addFilter(Product.FILTER)
                .build();
    }
}