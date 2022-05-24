package by.paul.application.two.util.parser.impl;

import by.paul.application.two.entity.Request;
import by.paul.application.two.util.id_generator.RequestIDGenerator;
import by.paul.application.two.configuration.ApplicationConstants;
import by.paul.application.two.util.ReaderUtil;
import by.paul.application.two.util.parser.IDataParser;
import by.paul.application.two.util.reflection.ReflectionUtil;

import java.util.ArrayList;
import java.util.List;

public class RequestParser implements IDataParser<Request> {
    ReaderUtil readerUtil = new ReaderUtil();
    ReflectionUtil reflectionUtil = new ReflectionUtil();
    RequestIDGenerator idGenerator = new RequestIDGenerator();

    @Override
    public List<Request> parseToList() {
        List<List<String>> list = readerUtil.getData(ApplicationConstants.RESOURCES_PATH + "request_storage.csv");
        List<Request> requestList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Request request = new Request();
            reflectionUtil.setFields(request, list.get(i));
            requestList.add(request);
            idGenerator.plusCount();
        }
        return requestList;
    }

    @Override
    public List<Request> parseToList(String filePath) {
        List<List<String>> list = readerUtil.getData(filePath);
        List<Request> requestList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Request request = new Request();
            reflectionUtil.setFields(request, list.get(i));
            requestList.add(request);
            idGenerator.plusCount();
        }
        return requestList;
    }
}
