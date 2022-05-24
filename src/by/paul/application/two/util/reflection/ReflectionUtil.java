package by.paul.application.two.util.reflection;


import java.lang.reflect.Field;
import java.util.List;

public class ReflectionUtil {
    StringParser stringParser = new StringParser();

    public boolean setField(Object targetObject, String fieldName, String fieldValue) {
        Field field;
        try {
            field = targetObject.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            field = null;
        }
        if (field == null) {
            return false;
        }
        field.setAccessible(true);
        try {
            field.set(targetObject, stringParser.parseString(fieldValue, field.getType()));
            return true;
        } catch (IllegalAccessException e) {
            System.out.println(field.getGenericType());
            return false;
        }
    }


    public void setFields(Object targetObject, List<String> fieldsValue) {
        Field[] fields = targetObject.getClass().getDeclaredFields();
        int count = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                field.set(targetObject, stringParser.parseString(fieldsValue.get(count), field.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    public Field[] getFields(Object targetObject) {
        Field[] fields;
        fields = targetObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        return fields;
    }
}
