package it.academy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_CONTACTS")
public class Contacts {

    @Column(name = "CONTACTS_ID",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "PHONENUMBER",nullable = false)
    private String poneNumber;

    @Column(name = "SITE")
    private String site;

    @Column(name = "REPOSITORY")
    private String repository;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SKYPE")
    private String skype;
}
