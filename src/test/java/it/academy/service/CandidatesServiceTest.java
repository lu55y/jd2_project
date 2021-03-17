package it.academy.service;

import it.academy.data.CandidatesDao;
import it.academy.data.DaoConfiguration;
import it.academy.model.Candidates;
import it.academy.service.builder.SQLBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;
@ContextConfiguration(classes = DaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidatesServiceTest {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    CandidatesDao candidatesDao;

//    @Autowired
//    SQLBuilder sqlBuilder;

    @Test
    public void findAll() {

    }

    @Test
    @Transactional
    public void createCustomQuery() {
        List<Candidates> byCustomQuery = candidatesDao.findByCustomQuery("select * from t_candidates;");
//        sqlBuilder.selectAll(Candidates.class).build();
    }
}