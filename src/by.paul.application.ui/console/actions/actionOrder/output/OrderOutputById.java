package by.paul.application.ui.console.actions.actionOrder.output;

import by.paul.application.ui.console.actions.actionOrder.OrderAction;

public class OrderOutputById extends OrderAction {
    @Override
    public void execute() {
        orderOutput.showList();
    }
}
