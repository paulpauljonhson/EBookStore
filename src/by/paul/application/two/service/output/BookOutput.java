package by.paul.application.two.service.output;

import by.paul.application.two.entity.Book;

import java.util.Comparator;
import java.util.List;

public class BookOutput extends OutputService<Book> implements IOutput<Book> {

    @Override
    public void showList() {
        bookStorage.getList().forEach(System.out::println);
    }

    @Override
    public void showList(List<Book> list) {
        list.forEach(System.out::println);
    }

    @Override
    public void showSortedList(Comparator<Book> comparator) {
        bookStorage.getList().stream().sorted(comparator).forEach(System.out::println);
    }

    @Override
    public void showSortedList(List<Book> list, Comparator<Book> comparator) {
        list.stream().sorted(comparator).forEach(System.out::println);
    }

    public void showDescription(String id){
        String list = bookStorage.getById(id).getDescription();

        for (String s: list.split("\\.")){
            System.out.println(s);
        }
    }



//    public List<Book> staleForMoreThen6Months(){
//        bookStorage.getList().stream().filter
//                (orderStorage.closedInPeriod(String.valueOf(LocalDate.now().minusMonths(6)) , String.valueOf(LocalDate.now()))
//                        .stream().anyMatch(order -> order.getBookName() ))
//    }




//    private void sortByID(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getId));
//    }
//
//    public void showSortedByIdDecrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getId).reversed());
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByAlphabetIncrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getBookName));
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByAlphabetDecrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getBookName).reversed());
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByReleaseDateIncrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getReleaseYear));
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByReleaseDateDecrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getReleaseYear).reversed());
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByPriceIncrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getPrice));
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByPriceDecrease(){
//        bookStorage.getList().sort(Comparator.comparing(Book::getPrice).reversed());
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedInStock(){
//        bookStorage.getList().sort(Comparator.comparing(Book::isInStock));
//        System.out.println(bookStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedOutOfStock(){
//        bookStorage.getList().sort(Comparator.comparing(Book::isInStock).reversed());
//        System.out.println(bookStorage.getList());
//        sortByID();

//    }

}
