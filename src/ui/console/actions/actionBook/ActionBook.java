package ui.console.actions.actionBook;

import by.paul.application.service.formatting.BookService;
import by.paul.application.service.output.BookOutput;
import ui.console.actions.Action;

abstract public class ActionBook implements Action {
    protected BookService bookService = new BookService();
    protected BookOutput bookOutput = new BookOutput();

}
