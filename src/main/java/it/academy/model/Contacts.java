package it.academy.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Contacts {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String poneNumber;

    @Column
    private String site;

    @Column
    private String repository;

    @Column
    private String email;

    @Column
    private String skype;


}
