package models;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Column(name = "name")
    private String name;

    @Getter
    @ManyToOne
    @JoinColumn(name = "id_line")
    private Line line;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Model> models;

    public Category() {

    }
}