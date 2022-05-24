package by.paul.application.two.service.sort;

import by.paul.application.two.entity.Order;

import java.util.Comparator;

public enum OrderSort {
    BY_ID(Comparator.comparing(Order::getId)),
    BY_ID_DECREASE(Comparator.comparing(Order::getId).reversed()),
    BY_CREATION_DATE(Comparator.comparing(Order::getCreationDate)),
    BY_CREATION_DATE_DECREASE(Comparator.comparing(Order::getCreationDate).reversed()),
    BY_COMPLETION_DATE(Comparator.comparing(Order::getCompletionDate)),
    BY_COMPLETION_DATE_DECREASE(Comparator.comparing(Order::getCompletionDate).reversed()),
    BY_TOTAL_PRICE(Comparator.comparing(Order::getTotalPrice)),
    BY_TOTAL_PRICE_DECREASE(Comparator.comparing(Order::getTotalPrice).reversed()),
    NEW_FIRST(Comparator.<Order, Boolean>comparing(order -> order.getStatus().contains("New"))
            .thenComparing(order -> order.getStatus().contains("Done")).reversed()),
    DONE_FIRST(Comparator.<Order, Boolean>comparing(order -> order.getStatus().contains("Done"))
            .thenComparing(order -> order.getStatus().contains("New")).reversed()),
    CANCELLED_FIRST(Comparator.<Order, Boolean>comparing(order -> order.getStatus().contains("Cancelled"))
            .thenComparing(order -> order.getStatus().contains("Done")).reversed());

    private final Comparator<Order> comparator;

    OrderSort(Comparator<Order> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Order> getComparator() {
        return comparator;
    }
}
