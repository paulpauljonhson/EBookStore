package by.paul.application.entity;

import by.paul.application.util.id_generator.RequestIDGenerator;

import java.util.Objects;

public class Request implements Entity ,Comparable<Request>{
    private String id;
    private String bookName;
    private Integer amount;

    public Request() {
    }

    public Request(String book, int amount) {
        this.id = new RequestIDGenerator().createID();
        this.bookName = book;
        this.amount = amount;
    }

    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) &&
                Objects.equals(bookName, request.bookName) &&
                Objects.equals(amount, request.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, amount);
    }

    @Override
    public int compareTo(Request o) {
        return getId().compareTo(o.getId());
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
