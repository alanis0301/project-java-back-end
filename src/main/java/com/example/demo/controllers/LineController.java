package com.example.demo.controllers;

import java.util.List;

import com.example.demo.dtos.LineDTO;

import com.example.demo.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/lines")
public class LineController {

    @Autowired
    private LineService lineService;

    @GetMapping
    public List<LineDTO> list(){
        return lineService.getAllLines();
    }

    @GetMapping("/{id}")
    public LineDTO getLineById(@PathVariable int id) {
        return lineService.getLineById(id);
    }

}
