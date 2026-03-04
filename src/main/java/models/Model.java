package models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Model(String name){
        this.name = name;
    }

    public Model() {

    }
}