package it.academy.service.builder;

public abstract class QueryBuilder {
    StringBuilder textQuery=new StringBuilder();


    public String getQuery(){
        return textQuery.toString();
    }
}
