package by.paul.application.entity;


import by.paul.application.util.id_generator.OrderIDGenerator;

import java.time.LocalDate;
import java.util.Objects;

public class Order implements Entity, Comparable<Order> {
    private String id;
    private String status;
    private String customerName;
    private String bookName;
    private Integer amount;
    private Double totalPrice;
    private LocalDate creationDate;
    private LocalDate completionDate;


    public Order() {
    }

    public Order(String customerName, String OrderedBook, int amount, Double totalPrice) {
        this.id = new OrderIDGenerator().createID();
        this.status = "New";
        this.customerName = customerName;
        this.bookName = OrderedBook;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.creationDate = LocalDate.now();
        this.completionDate = LocalDate.parse("1111-11-11");
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    private void setStatus(String status) {
        this.status = String.valueOf(status);
    }

    public void setAsDone() {
        setStatus("Done");
        setCompletionDate(LocalDate.now());
    }

    public void setAsCancelled() {
        setStatus("Cancelled");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(status, order.status) &&
                Objects.equals(customerName, order.customerName) &&
                Objects.equals(bookName, order.bookName) &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(creationDate, order.creationDate) &&
                Objects.equals(completionDate, order.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, customerName, bookName, amount, totalPrice, creationDate, completionDate);
    }

    @Override
    public String toString() {
        String str;
        if (!String.valueOf(completionDate).equals("1111-11-11")) {
            str = "Order{" +
                    "id='" + id + '\'' +
                    ", status='" + status + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", bookName='" + bookName + '\'' +
                    ", amount=" + amount +
                    ", totalPrice=" + totalPrice +
                    ", creationDate=" + creationDate +
                    ", completionDate=" + completionDate +
                    '}';
        } else {
            str = "Order{" +
                    "id='" + id + '\'' +
                    ", status='" + status + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", bookName='" + bookName + '\'' +
                    ", amount=" + amount +
                    ", totalPrice=" + totalPrice +
                    ", creationDate=" + creationDate +
                    ", completionDate=" + "Isn't complete" +
                    '}';
        }
        return str;
    }

    @Override
    public int compareTo(Order o) {
        return getId().compareTo(o.getId());
    }
}



