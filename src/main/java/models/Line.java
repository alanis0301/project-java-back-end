package models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "line")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "line", fetch = FetchType.LAZY)
    private List<Category> categories;


    public Line(String name){
        this.name = name;
    }

    public Line() {

    }
}