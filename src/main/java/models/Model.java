package models;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;


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
    private Category category;

    public Model() {

    }
}