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

    @JoinTable(name = "T_CONTACTS",joinColumns = {
            @JoinColumn(name = "F_PHONE_NUMBER"),
            @JoinColumn(name = "F_SITE"),
            @JoinColumn(name = "F_REPOSITORY"),
            @JoinColumn(name = "F_EMAIL"),
            @JoinColumn(name = "F_SKYPE")
    })
    private List<Contacts> contacts;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID")
    private Gender gender;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_CANDIDATES_TECHNOLOGIES_RELATIONSHIP",
            joinColumns = @JoinColumn(name = "CANDIDATES_ID"),
            inverseJoinColumns = @JoinColumn(name = "TECHNOLOGIES_ID"))
    private List<Technologies> technologies;

}
