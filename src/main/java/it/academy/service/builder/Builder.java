package it.academy.service.builder;

public interface Builder {

    Class<?> setEntity(Class<?> tClass);

    String build();
}
