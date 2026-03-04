package models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_line")
    private Line line;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Model> models;


    public Category(String name){
        this.name = name;
    }

    public Category() {

    }
}