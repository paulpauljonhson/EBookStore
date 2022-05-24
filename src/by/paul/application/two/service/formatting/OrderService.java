package by.paul.application.two.service.formatting;

import by.paul.application.two.entity.Book;
import by.paul.application.two.entity.Order;

import java.util.List;

public class OrderService extends FormatService<Order> {

    public OrderService() {
    }

    public Double getTotalPrice(String bookName, int amount) {
        Book book = bookStorage.getByName(bookName);
        return book.getPrice() * amount;
    }

    public void createOrder(String customerName, String orderedBook, int amount) {
        if (bookStorage.getByName(orderedBook) != null) {
            orderStorage.createOrder(customerName, orderedBook, amount, getTotalPrice(orderedBook, amount));
            if (!bookStorage.getByName(orderedBook).isInStock()) {
                requestStorage.createRequest(orderedBook, amount);
            }
        } else System.out.println("No such book in storage");
    }

    public void setOrderAsCancelled(int orderID) {
        orderStorage.setOrderAsCancelled(orderID);
    }

    public void setOrderAsDone(int orderID) {
        orderStorage.setOrderAsDone(orderID);
    }


    @Override
    public List<Order> getFullList() {
        return orderStorage.getList();
    }
}
