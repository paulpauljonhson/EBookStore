package ui.console.actions.actionOrder.output;

import ui.console.actions.actionOrder.OrderAction;

public class OrderOutputById extends OrderAction {
    @Override
    public void execute() {
        orderOutput.showList();
    }
}
