package by.paul.application.two.service;

import by.paul.application.two.repository.impl.BookStorage;
import by.paul.application.two.repository.impl.OrderStorage;
import by.paul.application.two.repository.impl.RequestStorage;

import java.util.List;

public abstract class Service {
    static protected BookStorage bookStorage = new BookStorage();
    static protected OrderStorage orderStorage = new OrderStorage();
    static protected RequestStorage requestStorage = new RequestStorage();

}

