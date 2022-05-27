package by.paul.application.service.formatting;

import by.paul.application.service.Service;

import java.util.List;

abstract public class FormatService<E> extends Service {

    abstract List<E> getFullList();
}
