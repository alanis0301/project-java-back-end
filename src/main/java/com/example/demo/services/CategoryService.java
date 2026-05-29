package com.example.demo.services;


import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.ModelDTO;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categories -> {
                    List<ModelDTO> modelsDTO = categories.getModels().stream()
                            .map(models -> new ModelDTO(models.getId(), models.getName()))
                            .collect(Collectors.toList());

                    return new CategoryDTO(categories.getId(), categories.getName(), modelsDTO);
                })
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria nao encontrada com ID: " + id));

        List<ModelDTO> modelsDTO = category.getModels().stream()
                .map(models -> new ModelDTO(models.getId(), models.getName()))
                .collect(Collectors.toList());

        return new CategoryDTO(category.getId(), category.getName(), modelsDTO);
    }
}