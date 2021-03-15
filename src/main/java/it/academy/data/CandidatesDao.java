package it.academy.data;

import it.academy.model.Candidates;

import java.util.List;

public interface CandidatesDao{

    String add(Candidates candidates);

    Candidates find(Long id);

    List<?> readCustomQuery(String query);
}
