package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Table(name = "model")
public class Model {

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
    private Category category;

    public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Model() {

    }
}