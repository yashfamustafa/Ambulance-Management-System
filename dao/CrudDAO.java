package dao;

import java.util.*;

public interface CrudDAO<T> {
    void insert(T obj);
    void update(T obj);
    void delete(int id);
    List<T> getAll();

    T getById(int id);   
}