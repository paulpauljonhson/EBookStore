package by.paul.application.two.repository;

import java.util.List;

public interface Storage<E> extends Cloneable {

    E getById(String id);

    E getByName(String name);

    List<E> getList();

    E delete(String id);

    E update(E e);

    E save(E e);

}