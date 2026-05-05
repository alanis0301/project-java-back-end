package com.example.demo.dtos;

import com.example.demo.models.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;


@Entity
@Table(name = "model")
public class ModelDTO {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "name")
    private String name;

    @Getter
    @ManyToOne
    @JoinColumn(name = "id_category")
    @JsonBackReference
    private CategoryDTO category;

    public ModelDTO(Model model){
        BeanUtils.copyProperties(model, this);
    }

    public ModelDTO() {

    }
}