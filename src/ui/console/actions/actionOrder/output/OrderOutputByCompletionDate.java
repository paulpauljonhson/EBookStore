package ui.console.actions.actionOrder.output;

import by.paul.application.service.sort.OrderSort;
import ui.console.actions.actionOrder.OrderAction;

public class OrderOutputByCompletionDate extends OrderAction {
    @Override
    public void execute() {
        orderOutput.showSortedList(OrderSort.BY_COMPLETION_DATE.getComparator());
    }
}
