package it.academy.service.util;

import it.academy.model.Candidates;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityClassScanner {

    private StringBuilder queryBuilder;
    private EntityClassScanner ecs;
    public static void main(String[] args) {
        init(Candidates.class);
    }

    public EntityClassScanner(Class<?> tClass) {
        init(tClass);
    }

    public static void init(Class<?> tClass) {
        String tableName = getTableName(tClass);


        Field[] fields = tClass.getDeclaredFields();
        List<String> collect = Arrays.stream(fields).map(field -> field.getName()).collect(Collectors.toList());

        Map<String, String> map = getFieldsMap(fields);
        System.out.println(map);

    }

    private static String getTableName(Class<?> tClass) {
        if (tClass.isAnnotationPresent(Table.class)) {
            return tClass.getAnnotation(Table.class).name().toLowerCase();
        }else return tClass.getName().toLowerCase();
    }

    private static Map<String, String> getFieldsMap(Field[] fields) {
        Map<String,String> map =new HashMap<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)){
                String columnName = field.getAnnotation(Column.class).name().toLowerCase();
                String fieldName = field.getName();
                map.put(fieldName,columnName);
            }else map.put(field.getName(), field.getName());
        }
        return map;
    }
}
