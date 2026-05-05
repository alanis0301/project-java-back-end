package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

import com.example.demo.models.Category;
import com.example.demo.models.Line;

@Getter
@Entity
@Table(name = "category")
public class CategoryDTO {

    @Getter //metodo get
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "name")
    private String name;

    @Getter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_line")
    private Line line;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ModelDTO> models;

    public CategoryDTO(Category category){
        BeanUtils.copyProperties(category, this);
    }

    public CategoryDTO(){

    }

}