package by.paul.application.service.formatting;

import by.paul.application.entity.Request;

import java.util.List;

public class RequestService extends FormatService<Request> {

    public RequestService() {
    }


    @Override
    public List<Request> getFullList() {
        return requestStorage.getList();
    }
}
