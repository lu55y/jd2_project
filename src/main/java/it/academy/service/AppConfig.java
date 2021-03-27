package it.academy.service;

import it.academy.model.Candidates;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("it.academy")
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        CandidatesService candidatesService=new CandidatesService();

        List<Candidates> customQuery = candidatesService.createCustomQuery("select * from cv_candidates.T_CANDIDATES;");
        System.out.println(customQuery);
    }
}
