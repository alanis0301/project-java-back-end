package com.example.demo.services;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.LineDTO;
import com.example.demo.dtos.ModelDTO;
import com.example.demo.models.Line;
import com.example.demo.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

    public List<LineDTO> getAllLines() {
        return lineRepository.findAll().stream()
                .map(line -> {
                    List<CategoryDTO> categoriesDTO = line.getCategories().stream()
                            .map(category -> {
                                List<ModelDTO> modelsDTO = category.getModels().stream()
                                        .map(model -> new ModelDTO(model.getId(), model.getName()))
                                        .collect(Collectors.toList());

                                return new CategoryDTO(category.getId(), category.getName(), modelsDTO);
                            })
                            .collect(Collectors.toList());

                    return new LineDTO(line.getId(), line.getName(), categoriesDTO);
                })
                .collect(Collectors.toList());
    }

    public LineDTO getLineById(int id) {
        Line line = lineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Linha nao encontrada com ID: " + id));

        List<CategoryDTO> categoriesDTO = line.getCategories().stream()
                .map(category -> {
                    List<ModelDTO> modelsDTO = category.getModels().stream()
                            .map(model -> new ModelDTO(model.getId(), model.getName()))
                            .collect(Collectors.toList());

                    return new CategoryDTO(category.getId(), category.getName(), modelsDTO);
                })
                .collect(Collectors.toList());

        return new LineDTO(line.getId(), line.getName(), categoriesDTO);
    }

}