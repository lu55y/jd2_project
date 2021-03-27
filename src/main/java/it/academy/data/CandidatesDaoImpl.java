package it.academy.data;

import it.academy.model.Candidates;
import it.academy.service.builder.SQLBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CandidatesDaoImpl implements CandidatesDao<Candidates> {

    private SessionFactory sessionFactory;

    @Autowired
    public CandidatesDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Override
    public List<Candidates> findAllCandidates(String query) {
        return sessionFactory.getCurrentSession()
                .createSQLQuery(query)
                .list();
    }

    @Override
    public List<Candidates> findByCustomQuery(String query) {
        return sessionFactory.getCurrentSession()
                .createSQLQuery(query)
                .list();
    }
}
