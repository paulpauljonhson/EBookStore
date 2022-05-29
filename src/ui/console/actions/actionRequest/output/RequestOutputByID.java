package ui.console.actions.actionRequest.output;

import ui.console.actions.actionRequest.RequestAction;

public class RequestOutputByID extends RequestAction {
    @Override
    public void execute() {
        requestOutput.showList();
    }
}
