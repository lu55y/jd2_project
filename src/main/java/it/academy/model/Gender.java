package it.academy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_GENDER")
public class Gender {

    @Column(name = "GENDER_ID")
    @Id
    private Integer id;

    @Column(name = "F_GENDER_NAME")
    private String gender;
}

