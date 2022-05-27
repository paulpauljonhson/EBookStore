package by.paul.application.repository.impl;

import by.paul.application.configuration.ApplicationConstants;
import by.paul.application.entity.Request;
import by.paul.application.repository.Storage;
import by.paul.application.util.WriterUtil;
import by.paul.application.util.parser.impl.RequestParser;

import java.util.List;

public class RequestStorage implements Storage<Request> {
    private static List<Request> requestList;
    private WriterUtil<Request> writerUtil = new WriterUtil<>();
    private RequestParser parser = new RequestParser();
    private String filePath;

    public RequestStorage(List<Request> requestList) {
        RequestStorage.requestList = requestList;
        this.filePath = ApplicationConstants.RESOURCES_PATH + "new_request_storage.csv";
    }

    public RequestStorage() {
        requestList = parser.parseToList();
        this.filePath = ApplicationConstants.RESOURCES_PATH + "request_storage.csv";
    }

    public RequestStorage(String filePath) {
        requestList = parser.parseToList(filePath);
        this.filePath = filePath;
    }


    private void changeCsvFile() {
        writerUtil.addData(filePath, requestList);
    }

    public void createRequest(String bookName, int amount) {
        if (getByName(bookName) != null) {
            Request exRequest = getByName(bookName);
            exRequest.setAmount(exRequest.getAmount() + amount);
            changeCsvFile();
        } else {
            Request request = new Request(bookName, amount);
            requestList.add(request);
            changeCsvFile();
        }
    }

    public void deleteIfEmpty(String bookName) {
        if (getByName(bookName).getAmount() <= 0) {
            requestList.remove(getByName(bookName));
            changeCsvFile();
        }
    }

    @Override
    public Request getById(String id) {
        return null;
    }

    @Override
    public Request getByName(String name) {
        for (Request request : requestList)
            if (request.getBookName().equals(name))
                return request;
        return null;
    }

    @Override
    public List<Request> getList() {
        return requestList;
    }

    @Override
    public Request delete(String id) {
        return null;
    }

    @Override
    public Request update(Request request) {
        return null;
    }

    @Override
    public Request save(Request request) {
        return null;
    }

    @Override
    public String toString() {
        return "RequestStorage{" +
                "requestList=" + requestList +
                '}';
    }

}