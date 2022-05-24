package by.paul.application.two.util.reflection;

//import by.paul.application.configuration.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringParser {
    public Object parseString(String string, Class clazz) {
        if (String.class.getName().equals(clazz.getName())) {
            return string;
        } else if (Double.class.getName().equals(clazz.getName())) {
            return Double.parseDouble(string);
        } else if (Integer.class.getName().equals(clazz.getName())) {
            return Integer.parseInt(string);
        } else if (Long.class.getName().equals(clazz.getName())) {
            return Long.parseLong(string);
        }else if (LocalDate.class.getName().equals(clazz.getName())){
            return LocalDate.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } else return null;
    }
}
