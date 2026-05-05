package com.example.demo.controllers;

import java.util.List;

import com.example.demo.dtos.CategoryDTO;

import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<CategoryDTO> list(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO listCategoriesById(@PathVariable Integer id) {
        return categoryRepository.findById(id).get();
    }

}
