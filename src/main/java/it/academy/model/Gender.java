package it.academy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Gender {

    @Id
    private Integer id;

    @Column
    private String gender;
}

