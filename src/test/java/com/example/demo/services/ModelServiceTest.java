package com.example.demo.services;

import com.example.demo.dtos.ModelDTO;
import com.example.demo.models.Model;
import com.example.demo.repositories.ModelRepository;
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

public class ModelServiceTest {

    @Mock
    private ModelRepository modelRepository;

    @InjectMocks
    private ModelService modelService;

    private Model model1;

    @Test
    void testGetAllModels(){
        int id = 1;

        model1 = new Model(id, "Model1");

        when(modelRepository.findAll()).thenReturn(Arrays.asList(model1)); //Entrega o model1 como lista ao inves de acessar o banco

        List<ModelDTO> result = modelService.getAllModels(); // Atribuo valor ao dto para nao mexer na entidade

        assertEquals(1, result.size());
        assertEquals("Model1", result.get(0).getName());
        assertEquals(id, result.get(0).getId());

    }

    @Test
    void testGetModelByIdFound(){
        int id = 1;

        model1 = new Model(id, "Model1");

        when(modelRepository.findById(id)).thenReturn(Optional.of(model1));

        ModelDTO result = modelService.getModelById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Model1", result.getName());
        verify(modelRepository).findById(id);
    }

    @Test
    void testGetModelByIdNotFound(){
        int id = 1;

        when(modelRepository.findById(id)).thenReturn(Optional.empty()); //Vai retornar vazio para testar

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            modelService.getModelById(id); // O mockito vai retornar o vazio e causar a excecao
        });

        assertEquals("Modelo nao encontrado com ID: " + id, exception.getMessage()); //compara as mensagens e confere se o erro que aconteceu eh o planejado no ModelService

        verify(modelRepository).findById(id); // verifica se o metodo foi chamado exatamente o id criado (1)
    }
}
