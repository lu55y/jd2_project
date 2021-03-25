package it.academy.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "T_CANDIDATES")
public class Candidates {

    @Column(name = "CANDIDATES_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "F_FIRSTNAME")
    private String firstName;

    @Column(name = "F_LASTNAME")
    private String lastName;

    @Column(name = "F_PATRONYMIC")
    private String patronymic;

    @Column(name = "F_BIRTHDATE")
    private Date birthdate;

    @OneToOne
    @JoinColumn(name = "CONTACTS_ID")
    private Contacts contacts;

    @OneToOne
    @JoinColumn(name = "GENDER_ID")
    private Gender gender;


    @ManyToMany
    @JoinTable(name = "T_CANDIDATES_TECHNOLOGIES_RELATIONSHIP",
            joinColumns = @JoinColumn(name = "F_CANDIDATES_ID",referencedColumnName = "CANDIDATES_ID"),
            inverseJoinColumns = @JoinColumn(name = "F_CANDIDATES_TECHNOLOGIES_ID",referencedColumnName ="TECHNOLOGIES_ID" ))
    private List<Technologies> technologies;
}
