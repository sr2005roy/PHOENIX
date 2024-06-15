package com.ecommerce.backendone.service;

import com.ecommerce.backendone.entity.Category;
import com.ecommerce.backendone.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
