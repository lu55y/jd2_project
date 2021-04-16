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


    public SQLBuilder find(Class<?> klass) {
        addEntityClass(klass);

        queryBuilder = new StringBuilder();
        String sep=" ";
        queryBuilder.append("SELECT * FROM ")
                .append(tableName)
                .append(sep)
                .append("t0 left join t_contacts t1 on t0.CONTACTS_ID=t1.CONTACTS_ID").append(sep)
                .append("left join t_gender t2 on t0.GENDER_ID=t2.GENDER_ID").append(sep)
                .append("left join t_candidates_technologies_relationship t3 on t0.CANDIDATES_ID=t3.CANDIDATES_ID").append(sep)
                .append("join t_technologies t4 on t3.CANDIDATES_TECHNOLOGIES_ID=t4.TECHNOLOGIES_ID");
        return this;
    }

    public SQLBuilder equal(String column, String value){
        if(fieldsMap.containsKey(column)){
            queryBuilder.append(" WERE ")
                    .append(column.toLowerCase())
                    .append("=")
                    .append("'")
                    .append(value)
                    .append("'");
            return this;
        }return this;
    }

    public SQLBuilder and(){
        queryBuilder.append(" AND ");
        return this;
    }

    public SQLBuilder or(){
        queryBuilder.append(" OR ");
        return this;
    }


    private void addEntityClass(Class<?> klass) {

        ecs = new EntityClassScanner();
        fieldsMap = ecs.getFieldsMap(klass);
        tableName = ecs.getTableName(klass);

    }


    @Override
    public String getQuery() {
        return queryBuilder.append(" ").toString();
    }
}
