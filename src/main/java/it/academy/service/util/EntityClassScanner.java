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

    private EntityClassScanner ecs;

    public EntityClassScanner() {
    }

    public Map<String, String> getFieldsMap(Class<?> tClass) {
        Field[] fields = tClass.getDeclaredFields();
        List<String> collect = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
        Map<String, String> map = new HashMap<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                String columnName = field.getAnnotation(Column.class).name().toLowerCase();
                String fieldName = field.getName();
                map.put(fieldName, columnName);
            } else map.put(field.getName(), field.getName());
        }
        return map;
    }

    public String getTableName(Class<?> tClass) {
        String tableName = "";
        if (tClass.isAnnotationPresent(Table.class)) {
            Table tableNameAnnotation = tClass.getAnnotation(Table.class);
            tableName = tableNameAnnotation.name().toLowerCase();
        }
        if (tableName.isEmpty()) {
            tableName = "t_" + tClass.getSimpleName().toLowerCase();
        }
        return tableName;
    }
}
