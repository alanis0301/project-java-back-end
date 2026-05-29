package com.example.demo.controllers;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.LineDTO;
import com.example.demo.dtos.ModelDTO;
import com.example.demo.services.LineService;
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
@WebMvcTest(LineController.class)
public class LineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LineService lineService;

    private LineDTO line1;

    @Test
    void testListLines() throws Exception{
        int id = 1;

        List<ModelDTO> mockedModels = Arrays.asList(
                new ModelDTO(1, "Model1"),
                new ModelDTO(2, "Model2")
        );

        List<CategoryDTO> mockedCategories = Arrays.asList(
                new CategoryDTO(1, "Category1", mockedModels),
                new CategoryDTO(2, "Category2", mockedModels)
        );

        line1 = new LineDTO(id, "Line1", mockedCategories);

        when(lineService.getAllLines()).thenReturn(Arrays.asList(line1));

        mockMvc.perform(get("/api/lines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$.[0].id").value(id))
                .andExpect(jsonPath("$.[0].name").value("Line1"))
                .andExpect(jsonPath("$.[0].categories.[0].id").value(1))
                .andExpect(jsonPath("$.[0].categories.[1].id").value(2))
                .andExpect(jsonPath("$.[0].categories.[0].name").value("Category1"))
                .andExpect(jsonPath("$.[0].categories.[1].name").value("Category2"))
                .andExpect(jsonPath("$.[0].categories.[0].models.[0].id").value(1))
                .andExpect(jsonPath("$.[0].categories.[0].models.[1].id").value(2))
                .andExpect(jsonPath("$.[0].categories.[0].models.[0].name").value("Model1"))
                .andExpect(jsonPath("$.[0].categories.[0].models.[1].name").value("Model2"))
                .andExpect(jsonPath("$.[0].categories.[1].models.[0].id").value(1))
                .andExpect(jsonPath("$.[0].categories.[1].models.[1].id").value(2))
                .andExpect(jsonPath("$.[0].categories.[1].models.[0].name").value("Model1"))
                .andExpect(jsonPath("$.[0].categories.[1].models.[1].name").value("Model2"));

        verify(lineService, times(1)).getAllLines();

    }

    @Test
    void testGetLineById() throws Exception{
        int id = 1;

        List<ModelDTO> mockedModels = Arrays.asList(
                new ModelDTO(1, "Model1"),
                new ModelDTO(2, "Model2")
        );

        List<CategoryDTO> mockedCategories = Arrays.asList(
                new CategoryDTO(1, "Category1", mockedModels),
                new CategoryDTO(2, "Category2", mockedModels)
        );

        line1 = new LineDTO(id, "Line1", mockedCategories);

        when(lineService.getLineById(id)).thenReturn(line1);

        mockMvc.perform(get("/api/lines/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Line1"))
                .andExpect(jsonPath("$.categories.[0].id").value(1))
                .andExpect(jsonPath("$.categories.[1].id").value(2))
                .andExpect(jsonPath("$.categories.[0].name").value("Category1"))
                .andExpect(jsonPath("$.categories.[1].name").value("Category2"))
                .andExpect(jsonPath("$.categories.[0].models.[0].id").value(1))
                .andExpect(jsonPath("$.categories.[0].models.[1].id").value(2))
                .andExpect(jsonPath("$.categories.[0].models.[0].name").value("Model1"))
                .andExpect(jsonPath("$.categories.[0].models.[1].name").value("Model2"))
                .andExpect(jsonPath("$.categories.[1].models.[0].id").value(1))
                .andExpect(jsonPath("$.categories.[1].models.[1].id").value(2))
                .andExpect(jsonPath("$.categories.[1].models.[0].name").value("Model1"))
                .andExpect(jsonPath("$.categories.[1].models.[1].name").value("Model2"));

        verify(lineService, times(1)).getLineById(id);

    }
}
