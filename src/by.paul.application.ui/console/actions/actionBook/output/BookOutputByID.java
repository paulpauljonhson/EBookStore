package by.paul.application.ui.console.actions.actionBook.output;

import by.paul.application.ui.console.actions.actionBook.ActionBook;

public class BookOutputByID extends ActionBook {
    @Override
    public void execute() {
        bookOutput.showList();
    }
}
