package it.academy.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private String patronymic;

    @Column
    private Date birthdate;

    @Column
    private List<Contacts> contacts;

    @Column
    private Gender gender;

    @Column
    @OneToMany(mappedBy = "technologies")
    private List<Technologies> technologies;

}
