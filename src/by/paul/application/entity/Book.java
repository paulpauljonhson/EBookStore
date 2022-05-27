package by.paul.application.entity;

import by.paul.application.util.id_generator.BookIDGenerator;

import java.util.Objects;

public class Book implements Entity, Comparable<Book> {
    private String id;
    private String bookName;
    private Integer releaseYear;
    private Double price;
    private Integer amount;
    private String inStock;
    private String description;

    public Book() {
    }

    public Book(String bookName, Integer releaseYear, Double price) {
        this.id = new BookIDGenerator().createID();
        this.bookName = bookName;
        this.releaseYear = releaseYear;
        this.price = price;
        setInStock();
    }

    public Book(String bookName, Integer releaseYear, Double price, Integer amount) {
        this.id = new BookIDGenerator().createID();
        this.bookName = bookName;
        this.releaseYear = releaseYear;
        this.price = price;
        this.amount = amount;
        setInStock();
    }


    public String getBookName() {
        return bookName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getPrice() {
        return price;
    }

    public String getInStock() {
        return inStock;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    private void changeAmount(int amount) {
        this.amount += amount;
        setInStock();
    }

    public void takeBookFromStock() {
        if (amount > 0) changeAmount(-1);
        else System.out.println("Недостаточно книг на складе");
    }

    public void takeBookFromStock(int amount) {
        if ((amount != 0) && (amount <= getAmount())) {
            changeAmount(-Math.abs(amount));
        } else if (amount > this.amount) System.out.println("Доступно к заказу количество книг - " + getAmount());
        else System.err.println("Заказ оформлен неверно!\n" +
                    "Введите необходимое количество книг");
    }

    public void addBookToStock() {
        changeAmount(1);
    }

    public void addBookToStock(int amount) {
        if (amount != 0) changeAmount(Math.abs(amount));
        else System.err.println("Заказ оформлен неверно!\n" +
                "Введите количество книг");
    }

    public void setInStock() {
        if (getAmount() == 0) this.inStock = "Out";
        else this.inStock = "Available";
    }

    public boolean isInStock() {
        return inStock.equals("Available");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(releaseYear, book.releaseYear) &&
                Objects.equals(price, book.price) &&
                Objects.equals(amount, book.amount) &&
                Objects.equals(inStock, book.inStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, releaseYear, price, amount, inStock);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                ", amount=" + amount +
                ", inStock='" + inStock + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return getId().compareTo(o.getId());
    }
}

