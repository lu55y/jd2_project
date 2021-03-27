package it.academy.service.builder;

import it.academy.service.util.EntityClassScanner;

public class SQLBuilder implements Builder {

    private EntityClassScanner ecs;
    private StringBuilder queryBuilder;
    private String tableName="";

    private SQLBuilder(StringBuilder queryBuilder){
        this.queryBuilder=queryBuilder;
    }




    public SQLBuilder select(Class<?> klass) {
        queryBuilder = new StringBuilder();
        ecs = new EntityClassScanner();

        tableName = ecs.getTableName(klass);
        String sep=" ";

        queryBuilder.append("select ")
                .append(columns)
                .append(tableName)
                .append(sep).append(";");
        return this;
    }


    public <T> SQLBuilder selectWithParams(Class<T> tClass,String... params) {

        return this;
    }

    @Override
    public Class<?> setEntity(Class<?> tClass) {
        return tClass;
    }

    @Override
    public String build() {
    return queryBuilder.toString();
    }
}
