package pl.coderslab.model;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NIP
    private String nip;

    @REGON
    private String regon;



}
