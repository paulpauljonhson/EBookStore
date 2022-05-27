package by.paul.application.service.sort;

import by.paul.application.entity.Book;

import java.util.Comparator;

public enum BookSort {
    BY_ID(Comparator.comparing(Book::getId)),
    BY_ID_DECREASE(Comparator.comparing(Book::getId).reversed()),
    BY_ALPHABET(Comparator.comparing(Book::getBookName)),
    BY_ALPHABET_DECREASE(Comparator.comparing(Book::getBookName).reversed()),
    BY_RELEASE_DATE(Comparator.comparing(Book::getReleaseYear)),
    BY_RELEASE_DATE_DECREASE(Comparator.comparing(Book::getReleaseYear).reversed()),
    BY_PRICE(Comparator.comparing(Book::getPrice)),
    BY_PRICE_DECREASE(Comparator.comparing(Book::getPrice).reversed()),
    BY_STOCK(Comparator.comparing(Book::isInStock)),
    BY_STOCK_DECREASE(Comparator.comparing(Book::isInStock).reversed());

    private final Comparator<Book> comparator;

    BookSort(Comparator<Book> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }
}

