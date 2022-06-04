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
    private Map<String, Menu> menuMap = new HashMap<>();
    private Menu rootMenu;

    private Builder() {
    }

    public static Builder getInstance() {
        return Objects.requireNonNullElse(instance, new Builder());
    }

    public Map<String, Menu> getMenuMap() {
        return menuMap;
    }

    public Menu BuildMenu() {
        rootMenu = new Menu();
        rootMenu.setName("Main Menu");
        menuMap.putIfAbsent(rootMenu.getName(), rootMenu);
        rootMenu.addMenuItem(new MenuItem("Book Menu", () -> {
        }, CreateBookMenu()));
        rootMenu.addMenuItem(new MenuItem("Order Menu", () -> {
        }, CreateOrderMenu()));
        rootMenu.addMenuItem(new MenuItem("Request Menu", () -> {
        }, CreateRequestMenu()));
        return rootMenu;
    }

    public Menu getRootMenu() {
        return BuildMenu();
    }


    private Menu CreateBookMenu() {
        if (menuMap.containsKey("Book menu")) return menuMap.get("Book menu");
        else {
            Menu bookMenu = new Menu();
            bookMenu.setName("Book menu");
            menuMap.putIfAbsent(bookMenu.getName(), bookMenu);
            bookMenu.addMenuItem(new MenuItem("Show list of books", () -> {
            }, CreateBookOutputMenu()));
            bookMenu.addMenuItem(new MenuItem("Return to main menu", () -> {
            }, rootMenu));
            return bookMenu;
        }
    }

    private Menu CreateBookOutputMenu() {
        if (menuMap.containsKey("Book output menu")) return menuMap.get("Book output menu");
        else {
            Menu bookOutputMenu = new Menu();
            bookOutputMenu.setName("Book output menu");
            menuMap.putIfAbsent(bookOutputMenu.getName(), bookOutputMenu);
            bookOutputMenu.addMenuItem(new MenuItem("Show sorted by ID", new BookOutputByID(), bookOutputMenu));
            bookOutputMenu.addMenuItem(new MenuItem("Show sorted by Release Date", new BookOutputByReleaseDate(), bookOutputMenu));
            bookOutputMenu.addMenuItem(new MenuItem("Show sorted by Price", new BookOutputByPrice(), bookOutputMenu));
            bookOutputMenu.addMenuItem(new MenuItem("Show books in Stock", new BookOutputByStock(), bookOutputMenu));
            bookOutputMenu.addMenuItem(new MenuItem("Return to Book menu", () -> {
            }, menuMap.get("Book menu")));
            return bookOutputMenu;
        }
    }

    private Menu CreateOrderMenu() {
        if (menuMap.containsKey("Order menu")) return menuMap.get("Order menu");
        else {
            Menu orderMenu = new Menu();
            orderMenu.setName("Order menu");
            menuMap.putIfAbsent(orderMenu.getName(), orderMenu);
            orderMenu.addMenuItem(new MenuItem("Show list of orders", () -> {
            }, CreateOrderOutputMenu()));
            orderMenu.addMenuItem(new MenuItem("Return to main menu", () -> {
            }, rootMenu));
            return orderMenu;
        }
    }

    private Menu CreateOrderOutputMenu() {
        if (menuMap.containsKey("Order output menu")) return menuMap.get("Order output menu");
        else {
            Menu orderOutputMenu = new Menu();
            orderOutputMenu.setName("Order output menu");
            menuMap.putIfAbsent(orderOutputMenu.getName(), orderOutputMenu);
            orderOutputMenu.addMenuItem(new MenuItem("Show sorted by ID", new OrderOutputById(), orderOutputMenu));
            orderOutputMenu.addMenuItem(new MenuItem("Show sorted by Completion Date", new OrderOutputByCompletionDate(), orderOutputMenu));
            orderOutputMenu.addMenuItem(new MenuItem("Show sorted by Total Price", new OrderOutputByTotalPrice(), orderOutputMenu));
            orderOutputMenu.addMenuItem(new MenuItem("Show sorted by Status", () -> {
            }, CreateOrderSortedByStatusMenu()));
            orderOutputMenu.addMenuItem(new MenuItem("Back", () -> {
            }, menuMap.get("Order menu")));
//        orderOutputMenu.addMenuItem(new MenuItem("Show sorted by",  , orderOutputMenu));
            return orderOutputMenu;
        }
    }

    private Menu CreateOrderSortedByStatusMenu() {
        if (menuMap.containsKey("Sorted by status")) return menuMap.get("Sorted by status");
        else {
            Menu sortedByStatus = new Menu();
            sortedByStatus.setName("Sorted by status");
            menuMap.putIfAbsent("Sorted by status", sortedByStatus);
            sortedByStatus.addMenuItem(new MenuItem("Show New First", new OrderOutputNewFirst(), sortedByStatus));
            sortedByStatus.addMenuItem(new MenuItem("Show Done First", new OrderOutputDoneFirst(), sortedByStatus));
            sortedByStatus.addMenuItem(new MenuItem("Show Cancelled First", new OrderOutputCancelledFirst(), sortedByStatus));
            sortedByStatus.addMenuItem(new MenuItem("Back", () -> {
            }, menuMap.get("Order output menu")));
            return sortedByStatus;
        }
    }

    private Menu CreateRequestMenu() {
        if (menuMap.containsKey("Request menu")) return menuMap.get("Request menu");
        else {
            Menu requestMenu = new Menu();
            requestMenu.setName("Request menu");
            menuMap.putIfAbsent(requestMenu.getName(), requestMenu);
            requestMenu.addMenuItem(new MenuItem("Show list of Requests", () -> {
            }, CreateRequestOutputMenu()));
            requestMenu.addMenuItem(new MenuItem("Return to main menu", () -> {
            }, rootMenu));
            return requestMenu;
        }
    }

    private Menu CreateRequestOutputMenu() {
        if (menuMap.containsKey("Request output menu")) return menuMap.get("Request output menu");
        else {
            Menu requestOutputMenu = new Menu();
            requestOutputMenu.setName("Request output menu");
            menuMap.putIfAbsent(requestOutputMenu.getName(), requestOutputMenu);
            requestOutputMenu.addMenuItem(new MenuItem("Show sorted by ID", new RequestOutputByID(), requestOutputMenu));
            requestOutputMenu.addMenuItem(new MenuItem("Show sorted by Amount of Requests", new RequestOutputByAmount(), requestOutputMenu));
            requestOutputMenu.addMenuItem(new MenuItem("Show sorted by Alphabet", new RequestOutputByAlphabet(), requestOutputMenu));
            requestOutputMenu.addMenuItem(new MenuItem("Back", () -> {
            }, menuMap.get("Request menu")));
            return requestOutputMenu;
        }
    }
}