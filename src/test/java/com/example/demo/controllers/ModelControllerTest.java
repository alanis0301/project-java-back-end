package com.example.demo.controllers;

import com.example.demo.dtos.ModelDTO;
import com.example.demo.services.ModelService;
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
@WebMvcTest(ModelController.class)
public class ModelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelService modelService;

    private ModelDTO model1;

    @Test
    void testListModels() throws Exception{
        int id = 1;

        model1 = new ModelDTO(id, "Model1");

        when(modelService.getAllModels()).thenReturn(Arrays.asList(model1));

        mockMvc.perform(get("/api/models"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(id))
                .andExpect(jsonPath("$.[0].name").value("Model1"));

        verify(modelService, times(1)).getAllModels();
    }

    @Test
    void testGetModelById() throws Exception{
        int id = 1;

        model1 = new ModelDTO(id, "Model1");

        when(modelService.getModelById(id)).thenReturn(model1);

        mockMvc.perform(get("/api/models/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Model1"));

        verify(modelService, times(1)).getModelById(id);
    }
}
