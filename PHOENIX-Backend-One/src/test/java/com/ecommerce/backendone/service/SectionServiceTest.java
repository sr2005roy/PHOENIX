package com.ecommerce.backendone.service;

import com.ecommerce.backendone.repository.SectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SectionServiceTest {

    private SectionService underTest;
    @Mock
    SectionRepository sectionRepository;

    @BeforeEach
    void setUp() {
        underTest = new SectionService(sectionRepository);
    }

    @Test
    void getAllSections_ShouldInvokeRepositoryFunction() {
        // When
        underTest.getAllSections();

        // Then
        verify(sectionRepository).findAll();
    }

    @Test
    void getSectionById_ShouldInvokeRepositoryFunction() {
        // Given
        Integer id = 1;

        // When
        underTest.getSectionById(id);

        // Then
        verify(sectionRepository).findById(id);
    }
}