package it.academy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "T_TECHNOLOGIES")
public class Technologies {

    @Column(name = "TECHNOLOGIES_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TECHNOLOGIESNAME")
    private String technologyName;

    @ManyToMany(mappedBy = "technologies")
    private List<Candidates> candidatesList;
}
