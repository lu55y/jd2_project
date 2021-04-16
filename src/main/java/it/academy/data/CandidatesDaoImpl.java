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

    @Autowired
    private SessionFactory factory;

//    private CandidatesDaoImpl(SessionFactory sessionFactory){
//        this.factory=sessionFactory;
//    }

    @Override
    public List<Candidates> findAllCandidates(String query) {
        return factory.getCurrentSession()
                .createSQLQuery(query)
                .addEntity(Candidates.class)
                .list();
    }

    @Override
    public List<Candidates> findByCustomQuery(String query) {
        return factory.getCurrentSession()
                .createSQLQuery(query)
                .addEntity(Candidates.class)
                .list();
    }
}
