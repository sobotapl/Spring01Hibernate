package pl.coderslab.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Size(min = 5)
    @Column(name = "title")
    private String title;

    @Range(min =1, max = 10, message ="Pole musi byc wieksze od 10")
    private Integer rating;

    @Size(min = 600)
    private String  description;

    @NotNull
    @ManyToOne
    @JoinColumn(name ="publisher_id")
    private Publisher publisher;

//    @ManyToMany(mappedBy = "books")
//    private List<Author> authors = new ArrayList<>();

    @NotNull
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @Min(2)
    private int pages;


}
