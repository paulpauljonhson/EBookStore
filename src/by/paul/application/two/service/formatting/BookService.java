package by.paul.application.two.service.formatting;

import by.paul.application.two.entity.Book;
import by.paul.application.two.entity.Order;
import by.paul.application.two.entity.Request;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BookService extends FormatService<Book> {

    public BookService() {
    }

    public void addBook(String bookName, int amount) {
        bookStorage.addToAmount(bookName, amount);
        if (requestStorage.getByName(bookName) != null) {
            Request request = requestStorage.getByName(bookName);
            request.setAmount(request.getAmount() - amount);
            requestStorage.deleteIfEmpty(bookName);
        }
    }

    @Override
    public List<Book> getFullList() {
        return bookStorage.getList();
    }

    public List<Book> getUnsoldFor6Months() {
        List<String> list = orderStorage.closedInPeriod(String.valueOf(LocalDate.now().minusMonths(6)), String.valueOf(LocalDate.now()))
                .stream()
                .map(Order::getBookName)
                .collect(Collectors.toList());

        return bookStorage.getList()
                .stream()
                .filter(book -> !list.contains(book.getBookName()) && book.isInStock())
                .collect(Collectors.toList());
    }
}
