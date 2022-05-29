package ui.console.actions.actionBook.output;

import ui.console.actions.actionBook.ActionBook;

public class BookOutputByID extends ActionBook {
    @Override
    public void execute() {
        bookOutput.showList();
    }
}
