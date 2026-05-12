package com.example.demo.controllers;

import java.util.List;

import com.example.demo.dtos.ModelDTO;

import com.example.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping
    public List<ModelDTO> list() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public ModelDTO getById(@PathVariable int id) {
        return modelService.getModelById(id);
    }
}