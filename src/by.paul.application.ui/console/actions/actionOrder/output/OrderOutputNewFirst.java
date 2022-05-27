package by.paul.application.ui.console.actions.actionOrder.output;

import by.paul.application.service.sort.OrderSort;
import by.paul.application.ui.console.actions.actionOrder.OrderAction;

public class OrderOutputNewFirst extends OrderAction {
    @Override
    public void execute() {
        orderOutput.showSortedList(OrderSort.NEW_FIRST.getComparator());
    }
}
