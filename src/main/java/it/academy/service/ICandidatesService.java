package it.academy.service;

import it.academy.model.Candidates;
import org.hibernate.annotations.NamedQuery;

import java.util.List;

public interface ICandidatesService {

    public List<Candidates> findAll(String query);

    public List<Candidates> createCustomQuery(String query);

}
