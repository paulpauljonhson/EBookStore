package by.paul.application.util.parser.impl;

import by.paul.application.entity.Order;
import by.paul.application.util.id_generator.OrderIDGenerator;
import by.paul.application.configuration.ApplicationConstants;
import by.paul.application.util.ReaderUtil;
import by.paul.application.util.parser.IDataParser;
import by.paul.application.util.reflection.ReflectionUtil;


import java.util.ArrayList;
import java.util.List;

public class OrderParser implements IDataParser<Order> {
    ReaderUtil readerUtil = new ReaderUtil();
    ReflectionUtil reflectionUtil = new ReflectionUtil();
    OrderIDGenerator idGenerator = new OrderIDGenerator();

    @Override
    public List<Order> parseToList() {
        List<List<String>> list = readerUtil.getData(ApplicationConstants.RESOURCES_PATH + "order_storage.csv");
        List<Order> orderList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Order order = new Order();
            reflectionUtil.setFields(order, list.get(i));
            orderList.add(order);
            idGenerator.plusCount();
        }
        return orderList;
    }

    @Override
    public List<Order> parseToList(String filePath) {
        List<List<String>> list = readerUtil.getData(filePath);
        List<Order> orderList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Order order = new Order();
            reflectionUtil.setFields(order, list.get(i));
            orderList.add(order);
            idGenerator.plusCount();
        }
        return orderList;
    }
}
