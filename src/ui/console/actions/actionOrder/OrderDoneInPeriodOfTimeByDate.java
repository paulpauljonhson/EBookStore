package ui.console.actions.actionOrder;

import by.paul.application.service.sort.OrderSort;

import java.util.Arrays;
import java.util.regex.Pattern;

public class OrderDoneInPeriodOfTimeByDate extends OrderAction {

    @Override
    public void execute() {
        System.out.println("Введите первую дату в формате [yyyy-MM-dd]");
        String date1 = scanner.next();
//        scanner.hasNext(Pattern.compile())
        System.out.println("Введите вторую дату в формате [yyyy-MM-dd]");
        String date2 = scanner.next();
        orderOutput.showSortedList(orderService.closedInPeriod(date1, date2), OrderSort.BY_COMPLETION_DATE.getComparator());
    }
}
