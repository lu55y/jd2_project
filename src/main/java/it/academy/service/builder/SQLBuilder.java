package it.academy.service.builder;


import com.mysql.cj.Query;
import it.academy.service.util.EntityClassScanner;

import javax.persistence.EntityManager;
import java.util.List;

public class SQLBuilder implements Builder {

    public SQLBuilder() {
    }

    @Override
    public void setEntity(Class<?> tClass) {
//        EntityClassScanner ecs=new EntityClassScanner(tClass);

    }

    @Override
    public void setParams(String params) {

    }

    public String buildQuery(){
    return null;
    }

    public List<String> getQueryParameters(){
        return null;
    }
}
