package by.paul.application.ui.console.actions.actionRequest.output;

import by.paul.application.service.sort.RequestSort;
import by.paul.application.ui.console.actions.actionRequest.RequestAction;

public class RequestOutputByAlphabet extends RequestAction {
    @Override
    public void execute() {
        requestOutput.showSortedList(RequestSort.BY_ALPHABET.getComparator());
    }
}
