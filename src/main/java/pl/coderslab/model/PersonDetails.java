package pl.coderslab.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "personsDetails")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "streetNumber")
    private int streetNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
