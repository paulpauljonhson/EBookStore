package by.paul.application.two.util.parser.impl;

import by.paul.application.two.entity.Book;
import by.paul.application.two.configuration.ApplicationConstants;
import by.paul.application.two.util.id_generator.BookIDGenerator;
import by.paul.application.two.util.ReaderUtil;
import by.paul.application.two.util.parser.IDataParser;
import by.paul.application.two.util.reflection.ReflectionUtil;

import java.util.ArrayList;
import java.util.List;

public class BookParser implements IDataParser<Book> {
    ReaderUtil readerUtil = new ReaderUtil();
    ReflectionUtil reflectionUtil = new ReflectionUtil();
    BookIDGenerator idGenerator = new BookIDGenerator();

    @Override
    public List<Book> parseToList() {
        List<List<String>> list = readerUtil.getData(ApplicationConstants.RESOURCES_PATH + "book_storage.csv");
        List<Book> bookList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Book book = new Book();
            reflectionUtil.setFields(book, list.get(i));
            bookList.add(book);
            idGenerator.plusCount();
        }
        return bookList;
    }

    @Override
    public List<Book> parseToList(String filePath) {
        List<List<String>> list = readerUtil.getData(filePath);
        List<Book> bookList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Book book = new Book();
            reflectionUtil.setFields(book, list.get(i));
            bookList.add(book);
            idGenerator.plusCount();
        }
        return bookList;
    }
}

