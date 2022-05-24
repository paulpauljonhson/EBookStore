package by.paul.application.two.service.output;

import by.paul.application.two.entity.Request;

import java.util.Comparator;
import java.util.List;

public class RequestOutput extends OutputService<Request> implements IOutput<Request> {

    @Override
    public void showList() {
        requestStorage.getList().forEach(System.out::println);
    }

    @Override
    public void showList(List<Request> list) {
        list.forEach(System.out::println);
    }

    @Override
    public void showSortedList(Comparator<Request> comparator) {
        requestStorage.getList().stream().sorted(comparator).forEach(System.out::println);
    }

    @Override
    public void showSortedList(List<Request> list, Comparator<Request> comparator) {
        list.stream().sorted(comparator).forEach(System.out::println);
    }
}
//
//        private void sortByID(){
//        requestStorage.getList().sort(Comparator.comparing(Request::getId));
//    }
//
//    public void showSortedByIdDecrease(){
//        requestStorage.getList().sort(Comparator.comparing(Request::getId).reversed());
//        System.out.println(requestStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByAlphabetIncrease() {
//        requestStorage.getList().sort(Comparator.comparing(Request::getBookName));
//        System.out.println(requestStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByAlphabetDecrease() {
//        requestStorage.getList().sort(Comparator.comparing(Request::getBookName).reversed());
//        System.out.println(requestStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByAmountIncrease(){
//        requestStorage.getList().sort(Comparator.comparing(Request::getAmount));
//        System.out.println(requestStorage.getList());
//        sortByID();
//    }
//
//    public void showSortedByAmountDecrease(){
//        requestStorage.getList().sort(Comparator.comparing(Request::getAmount).reversed());
//        System.out.println(requestStorage.getList());

//        sortByID();
//    }
//}
