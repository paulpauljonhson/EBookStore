package by.paul.application;

import by.paul.application.service.formatting.BookService;
import by.paul.application.repository.impl.BookStorage;
import by.paul.application.repository.impl.OrderStorage;
import by.paul.application.service.output.BookOutput;
import by.paul.application.service.output.OrderOutput;
import by.paul.application.service.sort.BookSort;

public class Main {
    public static void main(String[] args) {
        BookStorage bookStorage = new BookStorage();
        BookOutput bookOutput = new BookOutput();
        OrderStorage orderStorage = new OrderStorage();
        OrderOutput orderOutput = new OrderOutput();
        BookService bookService = new BookService();
//        List<Order> orderList = orderStorage.createdInPeriod("2022-04-02", "2022-05-02");
//        orderOutput.showSortedList(OrderSort.DONE_FIRST.getComparator());
//        orderOutput.showNewFirst();
//        orderOutput.showSortedList(OrderSort.NEW_FIRST.getComparator());

//        orderOutput.showSortedList(OrderSort.NEW_FIRST.getComparator());
//        System.out.println("-------------------");
//        orderOutput.showSortedList(OrderSort.DONE_FIRST.getComparator());
//        System.out.println("-------------------");
//        orderOutput.showSortedList(OrderSort.CANCELLED_FIRST.getComparator());

//        orderOutput.showList(orderList, );
//        RequestOutput requestOutput = new RequestOutput();


//        Comparator<Request> comparator = Comparator.comparing(Request::getId);

//        System.out.println(orderStorage.createdInPeriod("2022-03-02", "2022-05-02"));
//        orderStorage.createdInPeriod("2022-03-02", "2022-05-02").forEach(System.out::println);
//        orderOutput.showSortedList(orderStorage.completedInPeriod("2022-03-02", "2022-05-02"), OrderSort.BY_COMPLETION_DATE_DECREASE.getComparator());
//        orderStorage.closedInPeriod("2022-03-02", "2022-05-02").forEach(System.out::println);
//        System.out.println(orderStorage.earnedInPeriod("2022-03-02", "2022-05-02"));
//        System.out.println(orderStorage.doneInPeriod("2022-03-02", "2022-05-02"));
        //Список «залежавшихся» книг не проданы больше чем 6 мес. (сортировать по датепоступления, цене)

        bookOutput.showList();
        bookOutput.showSortedList(BookSort.BY_RELEASE_DATE.getComparator());

//        bookOutput.showList(bookService.getUnsoldFor6Months());
//
//        bookOutput.showDescription("1");
//
//        orderOutput.showOrderDetails("1");
//        orderOutput.showOrderDetails("2");

    }
}



