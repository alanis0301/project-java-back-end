package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

import com.example.demo.models.Line;


@Entity
@Table(name = "line")
public class LineDTO {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "name")
    private String name;

    @Getter
    @OneToMany(mappedBy = "line", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CategoryDTO> categories;

    @Override
    public String toString() {
        return name;
    }

    public LineDTO(Line line){
        BeanUtils.copyProperties(line, this);
    }

    public LineDTO() {

    }
}