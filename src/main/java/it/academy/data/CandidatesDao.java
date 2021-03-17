package it.academy.data;

import it.academy.model.Candidates;

import java.util.List;

public interface CandidatesDao<T>{

    List<T> findAllCandidates(String query);

    List<T> findByCustomQuery(String query);
}
