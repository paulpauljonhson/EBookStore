package by.paul.application.two.service.formatting;

import by.paul.application.two.service.Service;

import java.util.List;

abstract public class FormatService<E> extends Service {

    abstract List<E> getFullList();
}
