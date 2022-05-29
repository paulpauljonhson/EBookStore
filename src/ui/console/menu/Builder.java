package ui.console.menu;

import ui.console.actions.actionBook.output.BookOutputByID;
import ui.console.actions.actionBook.output.BookOutputByPrice;
import ui.console.actions.actionBook.output.BookOutputByReleaseDate;
import ui.console.actions.actionBook.output.BookOutputByStock;
import ui.console.actions.actionOrder.output.*;
import ui.console.actions.actionRequest.output.RequestOutputByAlphabet;
import ui.console.actions.actionRequest.output.RequestOutputByAmount;
import ui.console.actions.actionRequest.output.RequestOutputByID;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Builder {
    private static Builder instance;
    Map<String, Menu> menuMap = new HashMap<>();
    private Menu rootMenu;

    private Builder() {
        rootMenu = BuildMenu();
    }

    public static Builder getInstance() {
        return Objects.requireNonNullElse(instance, new Builder());
    }

    public Menu BuildMenu() {
        rootMenu = new Menu();
        rootMenu.setName("Main Menu");
        rootMenu.addMenuItem(new MenuItem("Book Menu", () -> {
        }, CreateBookMenu()));
        rootMenu.addMenuItem(new MenuItem("Order Menu", () -> {
        }, CreateOrderMenu()));
        rootMenu.addMenuItem(new MenuItem("Request Menu", () -> {
        }, CreateRequestMenu()));
        return rootMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }


    private Menu CreateBookMenu() {
        Menu bookMenu = new Menu();
        bookMenu.setName("Book menu");
        bookMenu.addMenuItem(new MenuItem("Show list of books", () -> {
        }, BookOutputMenu()));
        bookMenu.addMenuItem(new MenuItem("Return to main menu", () -> {
        }, rootMenu));
        menuMap.putIfAbsent(bookMenu.getName(), bookMenu);
        return bookMenu;
    }

    private Menu BookOutputMenu() {
        Menu bookOutputMenu = new Menu();
        bookOutputMenu.setName("Book menu");
        bookOutputMenu.addMenuItem(new MenuItem("Show sorted by ID", new BookOutputByID(), bookOutputMenu));
        bookOutputMenu.addMenuItem(new MenuItem("Show sorted by Release Date", new BookOutputByReleaseDate(), bookOutputMenu));
        bookOutputMenu.addMenuItem(new MenuItem("Show sorted by Price", new BookOutputByPrice(), bookOutputMenu));
        bookOutputMenu.addMenuItem(new MenuItem("Show books in Stock", new BookOutputByStock(), bookOutputMenu));
        bookOutputMenu.addMenuItem(new MenuItem("Return to Book menu", () -> {
        }, menuMap.get("Book menu")));
        return bookOutputMenu;
    }

    private Menu CreateOrderMenu() {
        Menu orderMenu = new Menu();
        orderMenu.setName("Order menu");
        orderMenu.addMenuItem(new MenuItem("Show list of orders", () -> {
        }, OrderOutputMenu()));
        orderMenu.addMenuItem(new MenuItem("Return to main menu", () -> {
        }, rootMenu));
        menuMap.putIfAbsent(orderMenu.getName(), orderMenu);
        return orderMenu;
    }

    private Menu OrderOutputMenu() {
        Menu orderOutputMenu = new Menu();
        orderOutputMenu.setName("Order output menu");
        orderOutputMenu.addMenuItem(new MenuItem("Show sorted by ID", new OrderOutputById(), orderOutputMenu));
        orderOutputMenu.addMenuItem(new MenuItem("Show sorted by Completion Date", new OrderOutputByCompletionDate(), orderOutputMenu));
        orderOutputMenu.addMenuItem(new MenuItem("Show sorted by Total Price", new OrderOutputByTotalPrice(), orderOutputMenu));
        orderOutputMenu.addMenuItem(new MenuItem("Show sorted by Status", () -> {
        }, SortedByStatus()));
        orderOutputMenu.addMenuItem(new MenuItem("Back", () -> {
        }, menuMap.get("Order menu")));
        menuMap.putIfAbsent(orderOutputMenu.getName(), orderOutputMenu);
//        orderOutputMenu.addMenuItem(new MenuItem("Show sorted by",  , orderOutputMenu));
        return orderOutputMenu;
    }

    private Menu SortedByStatus() {
        Menu sortedByStatus = new Menu();
        sortedByStatus.setName("Sorted by status");
        sortedByStatus.addMenuItem(new MenuItem("Show New First", new OrderOutputNewFirst(), sortedByStatus));
        sortedByStatus.addMenuItem(new MenuItem("Show Done First", new OrderOutputDoneFirst(), sortedByStatus));
        sortedByStatus.addMenuItem(new MenuItem("Show Cancelled First", new OrderOutputCancelledFirst(), sortedByStatus));
        sortedByStatus.addMenuItem(new MenuItem("Back", () -> {
        }, menuMap.get("Order output menu")));
        menuMap.putIfAbsent("Sorted by status", sortedByStatus);
        return sortedByStatus;
    }

    private Menu CreateRequestMenu() {
        Menu requestMenu = new Menu();
        requestMenu.setName("Request menu");
        requestMenu.addMenuItem(new MenuItem("Show list of Requests", () -> {
        }, RequestOutputMenu()));
        requestMenu.addMenuItem(new MenuItem("Return to main menu", () -> {
        }, rootMenu));
        menuMap.putIfAbsent(requestMenu.getName(), requestMenu);
        return requestMenu;
    }

    private Menu RequestOutputMenu() {
        Menu requestOutputMenu = new Menu();
        requestOutputMenu.setName("Request output menu");
        requestOutputMenu.addMenuItem(new MenuItem("Show sorted by ID", new RequestOutputByID(), requestOutputMenu));
        requestOutputMenu.addMenuItem(new MenuItem("Show sorted by Amount of Requests", new RequestOutputByAmount(), requestOutputMenu));
        requestOutputMenu.addMenuItem(new MenuItem("Show sorted by Alphabet", new RequestOutputByAlphabet(), requestOutputMenu));
        requestOutputMenu.addMenuItem(new MenuItem("Back", () -> {}, menuMap.get("Request menu")));
        return requestOutputMenu;
    }


}