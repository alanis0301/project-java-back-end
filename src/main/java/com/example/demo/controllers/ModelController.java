package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Model;

import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/models")
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping
    public List<Model> list(){
        return modelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Model listCategoriesById(@PathVariable Integer id) {
        return modelRepository.findById(id).get();
    }

}
