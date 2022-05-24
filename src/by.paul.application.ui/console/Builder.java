package by.paul.application.ui.console;

import java.util.Objects;

public class Builder {
    private static Builder instance;
    Menu rootMenu;

    private Builder() {
    }

    public static Builder getInstance() {
        return Objects.requireNonNullElse(instance, new Builder());
    }

    public void BuildMenu() {
        rootMenu = new Menu();
        rootMenu.setName("Main menu");
        rootMenu.addMenuItem(new MenuItem("Book Menu", () -> { }, createBookMenu()));
        rootMenu.addMenuItem(new MenuItem("Order Menu", () -> { }, createOrderMenu()));
        rootMenu.addMenuItem(new MenuItem("Request Menu", () -> { }, createRequestMenu()));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}