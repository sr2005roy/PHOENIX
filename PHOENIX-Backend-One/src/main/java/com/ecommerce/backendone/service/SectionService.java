package com.ecommerce.backendone.service;

import com.ecommerce.backendone.repository.SectionRepository;
import com.ecommerce.backendone.entity.Section;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectionService {

    @Autowired
    private SectionRepository repository;

    public List<Section> getAllSections() {
        return repository.findAll();
    }

    public Section getSectionById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
