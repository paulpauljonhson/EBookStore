package by.paul.application.two.service.formatting;

import by.paul.application.two.entity.Request;

import java.util.List;

public class RequestService extends FormatService<Request> {

    public RequestService() {
    }


    @Override
    public List<Request> getFullList() {
        return requestStorage.getList();
    }
}
