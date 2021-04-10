package it.academy.service.builder;

public abstract class QueryBuilder {
    StringBuilder textQuery=new StringBuilder();

    public abstract void addEntityClass(Class<?> klass);

    public String getQuery(){
        return textQuery.toString();
    }
}
