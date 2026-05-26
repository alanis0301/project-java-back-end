package com.example.demo.services;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.models.Category;
import com.example.demo.models.Model;
import com.example.demo.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category1;


    @Test
    void testGetAllCategories() {
        int id = 1;

        List<Model> mockedModels = Arrays.asList(
                new Model(1, "Model1"),
                new Model(2, "Model2")
        );

        category1 = new Category(id, "Cronos", mockedModels);

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1));

        List<CategoryDTO> result = categoryService.getAllCategories();

        assertEquals(1, result.size());
        assertEquals("Cronos", result.get(0).getName());
        assertEquals(id, result.get(0).getId());
        assertEquals("Model1", result.get(0).getModels().get(0).getName());
        assertEquals("Model2", result.get(0).getModels().get(1).getName());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testGetCategoryByIdFound() {
        int id = 1;

        List<Model> mockedModels = Arrays.asList(
                new Model(1, "Model1"),
                new Model(2, "Model2")
        );

        category1 = new Category(id, "Cronos", mockedModels);

        when(categoryRepository.findById(id)).thenReturn(Optional.of(category1));

        CategoryDTO result = categoryService.getCategoryById(1);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Cronos", result.getName());
        verify(categoryRepository).findById(id);
    }

    @Test
    void testGetCategoryByIdNotFound() {
        int id = 1;

        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            categoryService.getCategoryById(id);
        });

        assertEquals("Categoria nao encontrada com ID: " + id, exception.getMessage());

        verify(categoryRepository).findById(id);
    }
}
