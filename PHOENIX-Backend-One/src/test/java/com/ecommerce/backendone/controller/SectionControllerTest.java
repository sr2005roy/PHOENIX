package com.ecommerce.backendone.controller;

import com.ecommerce.backendone.service.SectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SectionControllerTest {

    private SectionController underTest;
    @Mock private SectionService sectionService;

    @BeforeEach
    void setUp() {
        underTest = new SectionController(sectionService);
    }

    @Test
    void getAllSections_ShouldQueryAllSections() {
        // When
        underTest.getAllSections();

        // Then
        verify(sectionService).getAllSections();
    }

    @Test
    void getSection_ShouldQuerySection() {
        // Given
        Integer id = 1;

        // When
        underTest.getSection(id);

        // Then
        verify(sectionService).getSectionById(id);
    }
}