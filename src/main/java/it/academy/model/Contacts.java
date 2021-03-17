package it.academy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_CONTACTS")
public class Contacts {

    @Column(name = "CONTACTS_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "F_PHONE_NUMBER")
    private String poneNumber;

    @Column(name = "F_SITE")
    private String site;

    @Column(name = "F_REPOSITORY")
    private String repository;

    @Column(name = "F_EMAIL")
    private String email;

    @Column(name = "F_SKYPE")
    private String skype;


}
