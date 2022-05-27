package by.paul.application.ui.console.menu;

import by.paul.application.ui.console.actions.Action;

public class MenuItem {
    private String title;
    private Action action;
    private Menu nextMenu;

    public MenuItem(String title, Action action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public Menu getNextMenu(){
        return nextMenu;
    }

    public void doAction(){
        action.execute();
    }
}
