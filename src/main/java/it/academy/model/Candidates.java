package it.academy.model;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "T_CANDIDATES")
public class Candidates {

    @Column(name = "CANDIDATES_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "FIRSTNAME",nullable = false)
    private String firstName;

    @Column(name = "LASTNAME",nullable = false)
    private String lastName;

    @Column(name = "PATRONYMIC",nullable = false)
    private String patronymic;

    @Column(name = "BIRTHDATE",nullable = false)
    private Date birthdate;

    @OneToOne
    @JoinColumn(name = "CONTACTS_ID",nullable = false)
    private Contacts contacts;

    @OneToOne
    @JoinColumn(name = "GENDER_ID",nullable = false)
    private Gender gender;


    @ManyToMany
    @JoinTable(name = "T_CANDIDATES_TECHNOLOGIES_RELATIONSHIP",
            joinColumns = @JoinColumn(name = "CANDIDATES_ID",referencedColumnName = "CANDIDATES_ID"),
            inverseJoinColumns = @JoinColumn(name = "CANDIDATES_TECHNOLOGIES_ID",referencedColumnName ="TECHNOLOGIES_ID" ))
    private List<Technologies> technologies;
}
