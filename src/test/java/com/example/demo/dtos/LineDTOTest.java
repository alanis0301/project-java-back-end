package com.example.demo.dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.*;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class LineDTOTest {

    private ModelDTO modelDTO;
    private CategoryDTO categoryDTO;
    private LineDTO lineDTO;

    @Test
    void lineDTOTest(){
        modelDTO =  new ModelDTO(1, "Model1");
        categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        lineDTO = new LineDTO();

        lineDTO.setId(1);
        lineDTO.setName("Line1");
        lineDTO.setCategories(Arrays.asList(categoryDTO));

        assertEquals(1, lineDTO.getId());
        assertEquals("Line1", lineDTO.getName());
        assertEquals(1, lineDTO.getCategories().get(0).getId());
        assertEquals("Category1", lineDTO.getCategories().get(0).getName());
        assertEquals(1, lineDTO.getCategories().get(0).getModels().get(0).getId());
        assertEquals("Model1", lineDTO.getCategories().get(0).getModels().get(0).getName());
    }

    @Test
    void lineDTOConstructorTest(){
        modelDTO =  new ModelDTO(1, "Model1");
        categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        lineDTO = new LineDTO(1, "Line1", Arrays.asList(categoryDTO));

        assertEquals(1, lineDTO.getId());
        assertEquals("Line1", lineDTO.getName());
        assertEquals(1, lineDTO.getCategories().get(0).getId());
        assertEquals("Category1", lineDTO.getCategories().get(0).getName());
        assertEquals(1, lineDTO.getCategories().get(0).getModels().get(0).getId());
        assertEquals("Model1", lineDTO.getCategories().get(0).getModels().get(0).getName());
    }
}
