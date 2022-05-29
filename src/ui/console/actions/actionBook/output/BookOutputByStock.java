package ui.console.actions.actionBook.output;

import by.paul.application.service.sort.BookSort;
import ui.console.actions.actionBook.ActionBook;

public class BookOutputByStock extends ActionBook {
    @Override
    public void execute() {
        bookOutput.showSortedList(BookSort.BY_STOCK.getComparator());
    }
}
