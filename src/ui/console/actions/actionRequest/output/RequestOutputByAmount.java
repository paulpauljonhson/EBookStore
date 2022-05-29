package ui.console.actions.actionRequest.output;

import by.paul.application.service.sort.RequestSort;
import ui.console.actions.actionRequest.RequestAction;

public class RequestOutputByAmount extends RequestAction {
    @Override
    public void execute() {
        requestOutput.showSortedList(RequestSort.BY_AMOUNT.getComparator());
    }
}
