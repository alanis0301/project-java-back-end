package com.example.demo.models;

import com.example.demo.dtos.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Getter //metodo get
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_line")
    private Line line;

    @Setter
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Model> models;

    public Category(int id, String name, List<Model> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public Category() {

    }
}