package com.example.demo.controllers;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.ModelDTO;
import com.example.demo.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CategoryController.class)
class CategoryControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private CategoryDTO category1;

    @Test
    void testListCategories() throws Exception{
        int id = 1;

        List<ModelDTO> mockedModels = Arrays.asList(
                new ModelDTO(1, "Model1"),
                new ModelDTO(2, "Model2")
        );

        category1 = new CategoryDTO(id, "Cronos", mockedModels);

        when(categoryService.getAllCategories()).thenReturn(Arrays.asList(category1));

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(id))
                .andExpect(jsonPath("$.[0].name").value("Cronos"))
                .andExpect(jsonPath("$.[0].models[0].id").value(1))
                .andExpect(jsonPath("$.[0].models[0].name").value("Model1"))
                .andExpect(jsonPath("$.[0].models[1].id").value(2))
                .andExpect(jsonPath("$.[0].models[1].name").value("Model2"));

        verify(categoryService, times(1)).getAllCategories();

    }

    @Test
    void testGetCategoryById() throws Exception{
        int id = 1;

        List<ModelDTO> mockedModels = Arrays.asList(
                new ModelDTO(1, "Model1"),
                new ModelDTO(2, "Model2")
        );

        category1 = new CategoryDTO(id, "Cronos", mockedModels);

        when(categoryService.getCategoryById(id)).thenReturn(category1);

        mockMvc.perform(get("/api/categories/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Cronos"))
                .andExpect(jsonPath("$.models[0].id").value(1))
                .andExpect(jsonPath("$.models[0].name").value("Model1"))
                .andExpect(jsonPath("$.models[1].id").value(2))
                .andExpect(jsonPath("$.models[1].name").value("Model2"));

        verify(categoryService, times(1)).getCategoryById(id);
    }
}