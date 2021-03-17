package it.academy.data;

import it.academy.model.Candidates;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CandidatesDaoImpl<T> implements CandidatesDao<T> {

    private SessionFactory sessionFactory;

    @Autowired
    public CandidatesDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @Override
    public List findByCustomQuery(String query, Class<T> klass) {
        return sessionFactory.getCurrentSession().createSQLQuery(query).getResultList();
    }
}
