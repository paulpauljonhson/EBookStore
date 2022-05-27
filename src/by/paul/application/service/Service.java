package by.paul.application.service;

import by.paul.application.repository.impl.BookStorage;
import by.paul.application.repository.impl.OrderStorage;
import by.paul.application.repository.impl.RequestStorage;

public abstract class Service {
    static protected BookStorage bookStorage = new BookStorage();
    static protected OrderStorage orderStorage = new OrderStorage();
    static protected RequestStorage requestStorage = new RequestStorage();

}

