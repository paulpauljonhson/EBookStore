package by.paul.application.service.output;

import java.util.Comparator;
import java.util.List;

public interface IOutput<E> {
    void showList();

    void showList(List<E> list);

    void showSortedList(Comparator<E> comparator);

    void showSortedList(List<E> list, Comparator<E> comparator);
}
