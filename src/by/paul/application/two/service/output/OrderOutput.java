package by.paul.application.two.service.output;

import by.paul.application.two.entity.Order;

import java.util.Comparator;
import java.util.List;

public class OrderOutput extends OutputService<Order> implements IOutput<Order> {


    @Override
    public void showList() {
        orderStorage.getList().forEach(System.out::println);
    }

    @Override
    public void showList(List<Order> list) {
        list.forEach(System.out::println);
    }

    @Override
    public void showSortedList(Comparator<Order> comparator) {
        orderStorage.getList().stream().sorted(comparator).forEach(System.out::println);
    }

    @Override
    public void showSortedList(List<Order> list, Comparator<Order> comparator) {
        list.stream().sorted(comparator).forEach(System.out::println);
    }

    public void showOrderDetails(String id) {
        Order order = orderStorage.getById(id);
        System.out.println("Customer name - " + order.getCustomerName() + "\n"
                + "Book name - " + order.getBookName() + ", amount -" + order.getAmount() + "\n"
                + "Total price equals " + order.getTotalPrice())  ;
    }
}
//    Standard sorting
//    private void sortByID(){
//        orderStorage.getList().sort(Comparator.naturalOrder());
//    }

//    public void showSortedByIdDecrease(){
//        orderStorage.getList().sort(Comparator.comparing(Order::getId).reversed());
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByCreationDateIncrease() {
//        orderStorage.getList().sort(Comparator.comparing(Order::getCreationDate));
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByCreationDateDecrease() {
//        orderStorage.getList().sort(Comparator.comparing(Order::getCreationDate).reversed());
//        System.out.println(orderStorage.getList());
//    }
//
//    public void showSortedByCompletionDateIncrease() {
//        orderStorage.getList().sort(Comparator.comparing(Order::getCompletionDate));
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByCompletionDateDecrease() {
//        orderStorage.getList().sort(Comparator.comparing(Order::getCompletionDate).reversed());
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByTotalPriceIncrease() {
//        orderStorage.getList().sort(Comparator.comparing(Order::getTotalPrice));
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByTotalPriceDecrease() {
//        orderStorage.getList().sort(Comparator.comparing(Order::getTotalPrice).reversed());
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//    public void showNewFirst() {
//        orderStorage.getList().sort(Comparator.comparing(order -> order.getStatus().contains("New")).reversed());
//        System.out.println(orderStorage.getList());
//    }

//    public void showDoneFirst() {
//        orderStorage.getList().sort(Comparator.<Order, Boolean>comparing(order -> order.getStatus().contains("Done")).reversed());
//        System.out.println(orderStorage.getList());
//    }}
//
//    public void showCancelledFirst() {
//        orderStorage.getList().sort(Comparator.<Order, Boolean>comparing(order -> order.getStatus().contains("Cancelled")).reversed());
//        System.out.println(orderStorage.getList());
//        sortByID();
//    }
//
//
//}
