package ar.com.quantum.dao;

import java.util.List;

public interface IDAO <T>{

    boolean insert(T entity);

    T get(Integer id);

    Boolean update(T entity);

    Boolean delete(T entity);

    List<T> getAll();

}
