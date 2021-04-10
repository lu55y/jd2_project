package it.academy.service;

import it.academy.data.CandidatesDao;
import it.academy.data.CandidatesDaoImpl;
import it.academy.data.DaoConfiguration;
import it.academy.model.Candidates;
import it.academy.service.builder.SQLBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;
@ContextConfiguration(classes = DaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidatesServiceTest {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    SQLBuilder sqlBuilder;

    @Autowired
    CandidatesService candidatesService;
//    SQLBuilder sqlBuilder;

    @Test
    public void findAll() {

    }

    @Test
    @Transactional
    public void createCustomQuery() {
//        String query = sqlBuilder
//                .equal("lastName", "Морская")
//                .and()
//                .equal("firstName", "Мария")
//                .getQuery();
//
//        System.out.println(query);
//
//        List<Candidates> customQuery = candidatesService.createCustomQuery(query);
//        customQuery.forEach(System.out::println);
    }
}