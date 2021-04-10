package it.academy.data;

import it.academy.model.Candidates;
import it.academy.service.builder.SQLBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CandidatesDaoImpl implements CandidatesDao<Candidates> {

    private SessionFactory factory;

    @Autowired
    private CandidatesDaoImpl(SessionFactory sessionFactory){
        this.factory=sessionFactory;
    }

    @Override
    public List<Candidates> findAllCandidates(String query) {
        Session session = factory.getCurrentSession();
        return session.createSQLQuery(query).addEntity(Candidates.class).getResultList();
    }

    @Override
    public List<Candidates> findByCustomQuery(String query) {
        Session session= factory.getCurrentSession();
        return session.createSQLQuery(query).addEntity(Candidates.class).getResultList();
    }
}
