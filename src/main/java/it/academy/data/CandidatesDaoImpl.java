package it.academy.data;

import it.academy.model.Candidates;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CandidatesDaoImpl implements CandidatesDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CandidatesDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Override
    public String add(Candidates candidates) {
        return (String) sessionFactory.getCurrentSession().save(candidates);
    }

    @Override
    public Candidates find(Long id) {
        return sessionFactory.getCurrentSession().get(Candidates.class, id);
    }

    @Override
    public List<?> readCustomQuery(String query) {
        return sessionFactory.getCurrentSession().createSQLQuery(query).getResultList();
    }
}
