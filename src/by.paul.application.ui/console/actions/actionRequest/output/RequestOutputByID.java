package by.paul.application.ui.console.actions.actionRequest.output;

import by.paul.application.ui.console.actions.actionRequest.RequestAction;

public class RequestOutputByID extends RequestAction {
    @Override
    public void execute() {
        requestOutput.showList();
    }
}
