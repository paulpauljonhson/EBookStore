package by.paul.application.ui.console.actions.actionOrder;

import by.paul.application.service.formatting.OrderService;
import by.paul.application.service.output.OrderOutput;
import by.paul.application.ui.console.actions.Action;

abstract public class OrderAction implements Action {
    protected OrderService orderService = new OrderService();
    protected OrderOutput orderOutput = new OrderOutput();
}
