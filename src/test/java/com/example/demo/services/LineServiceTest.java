package com.example.demo.services;

import com.example.demo.dtos.LineDTO;
import com.example.demo.models.Category;
import com.example.demo.models.Line;
import com.example.demo.models.Model;
import com.example.demo.repositories.LineRepository;
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
public class LineServiceTest {

    @Mock
    private LineRepository lineRepository;

    @InjectMocks
    private LineService lineService;

    private Line line1;


    @Test
    void testGetAllLine(){
        int id = 1;

        List<Model> mockedModels = Arrays.asList(
                new Model(1, "Model1"),
                new Model(2, "Model2")
        );

        List<Category> mockedCategories = Arrays.asList(
                new Category(1, "Category1", mockedModels),
                new Category(2, "Category2", mockedModels)
        );

        line1 = new Line(id, "Line1", mockedCategories);

        when(lineRepository.findAll()).thenReturn(Arrays.asList(line1));

        List<LineDTO> result = lineService.getAllLines();

        assertEquals(1, result.size()); // Se entrou 1 registro mockado, tem que sair exatamente 1 DTO na lista
        assertEquals("Line1", result.get(0).getName());
        assertEquals(id, result.get(0).getId());
        assertEquals("Category1", result.get(0).getCategories().get(0).getName());
        assertEquals("Category2", result.get(0).getCategories().get(1).getName());
        assertEquals("Model1", result.get(0).getCategories().get(0).getModels().get(0).getName());
        assertEquals("Model2", result.get(0).getCategories().get(0).getModels().get(1).getName());
        assertEquals("Model1", result.get(0).getCategories().get(1).getModels().get(0).getName());
        assertEquals("Model2", result.get(0).getCategories().get(1).getModels().get(1).getName());

        verify(lineRepository, times(1)).findAll();
    }

    @Test
    void testGetLineByIdFound(){
        int id = 1;

        List<Model> mockedModels = Arrays.asList(
                new Model(1, "Model1"),
                new Model(2, "Model2")
        );

        List<Category> mockedCategories = Arrays.asList(
                new Category(1, "Category1", mockedModels),
                new Category(2, "Category2", mockedModels)
        );

        line1 = new Line(id, "Line1", mockedCategories);

        when(lineRepository.findById(id)).thenReturn(Optional.of(line1));

        LineDTO result = lineService.getLineById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Line1", result.getName());
        assertEquals("Category1", result.getCategories().get(0).getName());
        assertEquals("Category2", result.getCategories().get(1).getName());
        assertEquals("Model1", result.getCategories().get(0).getModels().get(0).getName());
        assertEquals("Model2", result.getCategories().get(0).getModels().get(1).getName());
        assertEquals("Model1", result.getCategories().get(1).getModels().get(0).getName());
        assertEquals("Model2", result.getCategories().get(1).getModels().get(1).getName());

        verify(lineRepository).findById(id);
    }

    @Test
    void testGetLineByIdNotFound(){
        int id = 1;

        when(lineRepository.findById(id)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            lineService.getLineById(id);
        });

        assertEquals("Linha nao encontrada com ID: " + id, exception.getMessage());

        verify(lineRepository).findById(id);
    }
}
