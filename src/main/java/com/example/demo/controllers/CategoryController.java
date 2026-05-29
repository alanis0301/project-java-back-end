package com.example.demo.controllers;

import java.util.List;

import com.example.demo.dtos.CategoryDTO;

import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> list(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

}
