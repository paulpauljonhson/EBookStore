package by.paul.application.service.sort;

import by.paul.application.entity.Request;

import java.util.Comparator;

public enum RequestSort {
    BY_ID(Comparator.comparing(Request::getId)),
    BY_ID_DECREASE(Comparator.comparing(Request::getId).reversed()),
    BY_ALPHABET(Comparator.comparing(Request::getBookName)),
    BY_ALPHABET_DECREASE(Comparator.comparing(Request::getBookName).reversed()),
    BY_AMOUNT(Comparator.comparing(Request::getAmount)),
    BY_AMOUNT_DECREASE(Comparator.comparing(Request::getAmount).reversed());

    private final Comparator<Request> comparator;

    RequestSort(Comparator<Request> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Request> getComparator() {
        return comparator;
    }

}
