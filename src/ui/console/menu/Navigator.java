package ui.console.menu;

import java.util.List;
import java.util.Objects;

public class Navigator {

    private static Navigator instance;
    private Menu currentMenu;
    private Menu previousMenu;

    private Navigator() {
    }

    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public static Navigator getInstance() {
        return Objects.requireNonNullElse(instance, new Navigator());
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        List<MenuItem> items = currentMenu.getMenuItems();
        for (MenuItem item : items) {
            System.out.print(items.indexOf(item) + 1 + ". ");
            System.out.println(item.getTitle());
        }
    }

    public void navigate(int index) {
        if (currentMenu != null) {
//            previousMenu = currentMenu;
            MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
            menuItem.doAction();
            currentMenu = menuItem.getNextMenu();
        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
