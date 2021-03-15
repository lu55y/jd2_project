package it.academy.model;

import javax.persistence.*;

@Entity
public class Technologies {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @ManyToOne
    private String technologies;
}
