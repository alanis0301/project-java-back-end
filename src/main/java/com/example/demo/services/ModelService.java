package com.example.demo.services;


import com.example.demo.dtos.ModelDTO;
import com.example.demo.models.Model;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<ModelDTO> getAllModels() {
        return modelRepository.findAll().stream()
                .map(model -> new ModelDTO(model.getId(), model.getName()))
                            .collect(Collectors.toList());
    }

    public ModelDTO getModelById(int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo nao encontrado com ID: " + id));

        return new ModelDTO(model.getId(), model.getName());
    }
}
