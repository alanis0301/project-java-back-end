package com.example.demo.controllers;

import java.util.List;

import com.example.demo.dtos.LineDTO;

import com.example.demo.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/lines")
public class LineController {

    @Autowired
    private LineRepository lineRepository;

    @GetMapping
    public List<LineDTO> list(){
        return lineRepository.findAll();
    }

    @GetMapping("/{id}")
    public LineDTO listLinesById(@PathVariable Integer id) {
        return lineRepository.findById(id).get();
    }

}
