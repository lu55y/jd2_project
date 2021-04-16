package it.academy.service;


import it.academy.data.DaoConfiguration;
import it.academy.model.Candidates;
import it.academy.service.builder.SQLBuilder;
import it.academy.service.util.EntityClassScanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
//        List<Candidates> customQuery = candidatesService.createCustomQuery("select * from T_CANDIDATES");

        EntityClassScanner entityClassScanner=new EntityClassScanner();
        String tableName = entityClassScanner.getTableName(Candidates.class);
        System.out.println(tableName);

        Map<String, String> fieldsMap = entityClassScanner.getFieldsMap(Candidates.class);
        System.out.println(fieldsMap);

        String query = sqlBuilder.find(Candidates.class).getQuery();
        System.out.println(query);


        List<Candidates> customQuery = candidatesService.createCustomQuery(query);

        System.out.println(customQuery.get(1));
    }

    @Test
    @Transactional
    public void createCustomQuery() {
//        String query = sqlBuilder
//                .equal("lastName", "Морская")
//                .and()
//                .equal("firstName", "Мария")
//                .getQuery();

//        System.out.println(query);

//        List<Candidates> customQuery = candidatesService.createCustomQuery(query);
//        customQuery.forEach(System.out::println);
    }
}