package by.paul.application.repository.impl;

import by.paul.application.entity.Order;
import by.paul.application.repository.Storage;
import by.paul.application.configuration.ApplicationConstants;
import by.paul.application.util.WriterUtil;
import by.paul.application.util.parser.impl.OrderParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class OrderStorage implements Storage<Order> {
    private static List<Order> orderList;
    private static final OrderParser parser = new OrderParser();
    private static final WriterUtil<Order> writerUtil = new WriterUtil<>();
    private final String filePath;

    public OrderStorage(List<Order> orderList) {
        OrderStorage.orderList = orderList;
        this.filePath = ApplicationConstants.RESOURCES_PATH + "new_order_storage.csv";
    }

    public OrderStorage() {
        orderList = parser.parseToList();
        this.filePath = ApplicationConstants.RESOURCES_PATH + "order_storage.csv";
    }

    public OrderStorage(String filePath) {
        orderList = parser.parseToList(filePath);
        this.filePath = filePath;
    }

    private void changeCsvFile() {
        writerUtil.addData(filePath, orderList);
    }

    public void createOrder(String customerName, String orderedBook, int amount, Double totalPrice) {
        Order order = new Order(customerName, orderedBook, amount, totalPrice);
        if (orderList.contains(order)) {
            System.out.println("This order already exists");
        } else {
            orderList.add(order);
            changeCsvFile();
        }
    }

    public void setOrderAsCancelled(int orderID) {
        getById(String.valueOf(orderID)).setAsCancelled();
        changeCsvFile();
    }

    public void setOrderAsDone(int orderID) {
        getById(String.valueOf(orderID)).setAsDone();
        changeCsvFile();
    }

    public List<Order> createdInPeriod(String startDate, String endDate) {
        List<Order> ordersInPeriod = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCreationDate().isBefore(LocalDate.parse(endDate)) && order.getCreationDate().isAfter(LocalDate.parse(startDate))
                    || order.getCreationDate().isEqual(LocalDate.parse(startDate)) || order.getCreationDate().isEqual(LocalDate.parse(endDate))) {
                ordersInPeriod.add(order);
            }
        }
        return ordersInPeriod;
    }

    public List<Order> closedInPeriod(String startDate, String endDate) {
        List<Order> ordersInPeriod = new ArrayList<>();
        for (Order order : orderList) {
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

    public double doneInPeriod(String startDate, String endDate) {
        return closedInPeriod(startDate, endDate).stream()
                .filter(order -> order.getStatus().equals("Done"))
                .count();
    }



    public Order getByBookName(String bookName) {
        for (Order order : orderList)
            if (order.getBookName().equals(bookName))
                return order;
        return null;
    }

    @Override
    public Order getById(String id) {
        for (Order order : orderList)
            if (order.getId().equals(id))
                return order;
        return null;
    }

    @Override
    public Order getByName(String customerName) {
        for (Order order : orderList)
            if (order.getCustomerName().equals(customerName))
                return order;
        return null;
    }

    @Override
    public List<Order> getList() {
        return orderList;
    }

    @Override
    public Order delete(String id) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStorage that = (OrderStorage) o;
        return Objects.equals(filePath, that.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderList, parser, writerUtil, filePath);
    }

    @Override
    public String
    toString() {
        return "OrderStorage{" +
                "orderList=" + orderList +
                '}';
    }
}
