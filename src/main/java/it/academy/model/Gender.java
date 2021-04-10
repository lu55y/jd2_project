package it.academy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_GENDER")
public class Gender {

    @Column(name = "GENDER_ID",nullable = false)
    @Id
    private Integer id;

    @Column(name = "GENDER",nullable = false)
    private String gender;
}

