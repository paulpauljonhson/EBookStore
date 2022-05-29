package ui.console.actions.actionRequest;

import by.paul.application.service.formatting.RequestService;
import by.paul.application.service.output.RequestOutput;
import ui.console.actions.Action;

abstract public class RequestAction implements Action {
    protected RequestService requestService = new RequestService();
    protected RequestOutput requestOutput = new RequestOutput();
}
