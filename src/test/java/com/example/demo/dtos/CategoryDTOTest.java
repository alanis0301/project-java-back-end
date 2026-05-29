package com.example.demo.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class CategoryDTOTest {

    private CategoryDTO categoryDTO;
    private ModelDTO modelDTO;

    @Test
    void categoryDTOTest(){
        modelDTO = new ModelDTO(1, "Model1");
        categoryDTO = new CategoryDTO();

        categoryDTO.setId(1);
        categoryDTO.setName("Category1");
        categoryDTO.setModels(Arrays.asList(modelDTO));

        assertEquals(1, categoryDTO.getId());
        assertEquals("Category1", categoryDTO.getName());
        assertEquals(1, categoryDTO.getModels().get(0).getId());
        assertEquals("Model1", categoryDTO.getModels().get(0).getName());
    }
}
