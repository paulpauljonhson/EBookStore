package ui.console.actions.actionOrder;

import by.paul.application.service.formatting.OrderService;
import by.paul.application.service.output.OrderOutput;
import ui.console.actions.Action;

import java.util.Scanner;

abstract public class OrderAction implements Action {
    protected OrderService orderService = new OrderService();
    protected OrderOutput orderOutput = new OrderOutput();
    protected Scanner scanner = new Scanner(System.in);
}
