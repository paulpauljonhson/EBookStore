package by.paul.application.two.util.parser;

import java.util.List;

public interface IDataParser<E> {

    List<E> parseToList();

    List<E> parseToList(String filePath);

}
