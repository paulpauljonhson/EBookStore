package by.paul.application.util;

import by.paul.application.util.reflection.ReflectionUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class WriterUtil<E> {
    ReflectionUtil reflectionUtil = new ReflectionUtil();

    public void addData(String pathToFile, List<E> list) {
        Field[] fields = reflectionUtil.getFields(list.get(0));
        StringBuilder builder = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            for (Field fieldType : fields) {
                builder.append(fieldType.getName())
                        .append(";");
            }
            builder.deleteCharAt(builder.lastIndexOf(";"));
            writer.write(String.valueOf(builder));
            writer.newLine();
            for (E entity : list) {
                builder.delete(0, builder.length());
                fields = reflectionUtil.getFields(entity);
                for (Field field : fields) {
                    try {
                        builder.append(field.get(entity))
                                .append(";");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                builder.deleteCharAt(builder.lastIndexOf(";"));
                writer.write(String.valueOf(builder));
                writer.newLine();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}


