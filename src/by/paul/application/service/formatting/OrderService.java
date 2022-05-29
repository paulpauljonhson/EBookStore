package by.paul.application.service.formatting;

import by.paul.application.entity.Book;
import by.paul.application.entity.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Order> closedInPeriod(String startDate, String endDate) {
        List<Order> ordersInPeriod = new ArrayList<>();
        for (Order order : orderStorage.getList()) {
            if (order.getCompletionDate().isBefore(LocalDate.parse(endDate)) && order.getCompletionDate().isAfter(LocalDate.parse(startDate))
                    || order.getCompletionDate().isEqual(LocalDate.parse(startDate)) || order.getCompletionDate().isEqual(LocalDate.parse(endDate))) {
                ordersInPeriod.add(order);
            }
        }
        return ordersInPeriod;
    }

    public double earnedInPeriod(String startDate, String endDate) {
        return closedInPeriod(startDate, endDate).stream()
                .filter(order -> order.getStatus().equals("Done"))
                .reduce(0.0, (a, order) -> a + order.getTotalPrice(), (aDouble, aDouble2) -> aDouble + aDouble2);
    }

    public int doneInPeriod(String startDate, String endDate) {
        return (int) closedInPeriod(startDate, endDate).stream()
                .filter(order -> order.getStatus().equals("Done"))
                .count();
    }

    public List<String> getUnsoldFor6Months() {
        List<String> list = closedInPeriod(String.valueOf(LocalDate.now().minusMonths(6)), String.valueOf(LocalDate.now()))
                .stream()
                .map(Order::getBookName)
                .collect(Collectors.toList());
        return list;}
    @Override
    public List<Order> getFullList() {
        return orderStorage.getList();
    }
}
