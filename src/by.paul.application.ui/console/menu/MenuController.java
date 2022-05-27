package by.paul.application.ui.console.menu;

import java.util.Objects;
import java.util.Scanner;

public class MenuController {

    private static MenuController instance;
    private final Navigator navigator;
    private Builder builder;

    public MenuController() {
        builder = Builder.getInstance();
        builder.BuildMenu();
        navigator = Navigator.getInstance();
    }

    public static MenuController getInstance() {
        return Objects.requireNonNullElse(instance, new MenuController());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        int index = 1;
        while (index > 0) {
            index = scanner.nextInt();
            try {
                navigator.navigate(index);
            }catch (IndexOutOfBoundsException e){
                if (index == 0){
                    System.out.println("so long, gay user");
                    break;
                }else System.out.println("wrong namba");
            }
//            System.out.println(builder.menuMap.);
            navigator.printMenu();
        }
    }
}
