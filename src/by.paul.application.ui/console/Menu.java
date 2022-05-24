package by.paul.application.ui.console;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String name;
    List<MenuItem> menuItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }
        return menuItems;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }


}
