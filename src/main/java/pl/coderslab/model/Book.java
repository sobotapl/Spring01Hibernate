package pl.coderslab.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    private Integer rating;

    private String  description;

    @ManyToOne
    @JoinColumn(name ="publisher_id")
    private Publisher publisher;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();


}
