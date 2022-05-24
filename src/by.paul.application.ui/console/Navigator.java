package by.paul.application.ui.console;

import java.util.List;
import java.util.Objects;

public class Navigator {

    private static Navigator instance;
    Menu currentMenu;

    private Navigator() {
    }

    public static Navigator getInstance() {
        return Objects.requireNonNullElse(instance, new Navigator());
    }


    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        List<MenuItem> items = currentMenu.getMenuItems();
        for (MenuItem item : items) {
            System.out.println(item.getTitle());
        }
    }

    public void navigate(int index) {
        if (currentMenu != null) {
            MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
            menuItem.doAction();
            currentMenu = menuItem.getNextMenu();
        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
