package by.paul.application.repository.impl;

import by.paul.application.entity.Book;
import by.paul.application.repository.Storage;
import by.paul.application.util.WriterUtil;
import by.paul.application.util.parser.impl.BookParser;

import java.util.List;

import static by.paul.application.configuration.ApplicationConstants.RESOURCES_PATH;

public class BookStorage implements Storage<Book> {
    private static List<Book> bookList;
    private BookParser parser = new BookParser();
    private WriterUtil<Book> writerUtil = new WriterUtil<>();
    private String filePath;


    public BookStorage(List<Book> bookList) {
        BookStorage.bookList = bookList;
        this.filePath = RESOURCES_PATH + "new_book_storage.csv";
    }

    public BookStorage() {
        bookList = parser.parseToList();
        this.filePath = RESOURCES_PATH + "book_storage.csv";
    }

    public BookStorage(String filePath) {
        bookList = parser.parseToList(filePath);
        this.filePath = filePath;
    }

    private void changeCsvFile() {
        writerUtil.addData(filePath, bookList);
    }



    public void addToAmount(String bookName, int amount) {
        Book book = getByName(bookName);
        book.addBookToStock(amount);
        changeCsvFile();
    }

    @Override
    public Book getById(String id) {
        for (Book book : bookList)
            if (book.getId().equals(id))
                return book;
        return null;
    }

    @Override
    public Book getByName(String bookName) {
        for (Book book : bookList)
            if (book.getBookName().equals(bookName))
                return book;
        return null;
    }

    @Override
    public List<Book> getList() {
        return bookList;
    }

    @Override
    public Book delete(String id) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public String toString() {
        return "BookStorage{" +
                "bookList=" + bookList +
                '}';
    }
}
