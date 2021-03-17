package it.academy.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICandidatesService<T> {

    public List<T> findAll(String query);

    public List<T> createCustomQuery (String query);

}
