package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "line")
public class Line {

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
    private List<Category> categories;

    @Override
    public String toString() {
        return name;
    }

    public Line() {

    }
}