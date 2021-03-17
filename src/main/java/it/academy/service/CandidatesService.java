package it.academy.service;

import it.academy.data.CandidatesDao;
import it.academy.model.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidatesService<T>{

    @Autowired
    private CandidatesDao candidatesDao;

    @Transactional
    public List<T> createCustomQuery (String query,Class<T> klass) {
        return candidatesDao.findByCustomQuery(query,klass);
    }

}
