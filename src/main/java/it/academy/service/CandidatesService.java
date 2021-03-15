package it.academy.service;

import it.academy.data.CandidatesDao;
import it.academy.model.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidatesService{

    @Autowired
    private CandidatesDao candidatesDao;

    @Transactional
    public Candidates findCandidatesById(Long id) {
        return candidatesDao.find(id);
    }

    @Transactional
    public String saveNewCandidates(Candidates candidates) {
        return candidatesDao.add(candidates);
    }

    @Transactional
    public List<?> createCustomQuery (String query) {
        return candidatesDao.readCustomQuery(query);
    }

}
