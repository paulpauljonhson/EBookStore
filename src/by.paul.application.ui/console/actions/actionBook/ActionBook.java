package by.paul.application.ui.console.actions.actionBook;

import by.paul.application.entity.Request;
import by.paul.application.service.formatting.BookService;
import by.paul.application.service.formatting.OrderService;
import by.paul.application.service.formatting.RequestService;
import by.paul.application.service.output.BookOutput;
import by.paul.application.ui.console.actions.Action;

abstract public class ActionBook implements Action {
    protected BookService bookService = new BookService();
    protected BookOutput bookOutput = new BookOutput();

}
