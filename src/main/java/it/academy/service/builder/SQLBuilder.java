package it.academy.service.builder;

import it.academy.service.util.EntityClassScanner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SQLBuilder extends QueryBuilder {

    private EntityClassScanner ecs;

    private StringBuilder queryBuilder;
    private String tableName="";
    private Map<String, String> fieldsMap=null;


    public SQLBuilder findAll(Class<?> klass) {
        addEntityClass(klass);

        queryBuilder = new StringBuilder();
        String sep=" ";
        queryBuilder.append("SELECT * FROM ")
                .append(tableName)
                .append(sep);
        return this;
    }

    public SQLBuilder equal(String column, String value){
        if(fieldsMap.containsKey(column)){
            queryBuilder.append(" WERE ")
                    .append(column.toLowerCase())
                    .append("=")
                    .append(value);
            return this;
        }return this;
    }

    public SQLBuilder and(){
        queryBuilder.append(" AND ");
        return this;
    }


    @Override
    public void addEntityClass(Class<?> klass) {

        ecs = new EntityClassScanner();
        fieldsMap = ecs.getFieldsMap(klass);
        tableName = ecs.getTableName(klass);

    }


    @Override
    public String getQuery() {
        return queryBuilder.append(" ").toString();
    }


}
