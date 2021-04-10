package it.academy.service;

import it.academy.data.CandidatesDaoImpl;
import it.academy.model.Candidates;
import it.academy.service.builder.SQLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("candidatesService")
public class CandidatesService{

    @Autowired
    private CandidatesDaoImpl candidatesDao;

    @Autowired
    SQLBuilder sqlBuilder;

    @Transactional
    public List<Candidates> findAll(){
        String query = sqlBuilder.findAll(Candidates.class).getQuery();
        return candidatesDao.findAllCandidates(query);
    }

    @Transactional
    public List<Candidates> createCustomQuery (String query) {
        return candidatesDao.findByCustomQuery(query);
    }
}
