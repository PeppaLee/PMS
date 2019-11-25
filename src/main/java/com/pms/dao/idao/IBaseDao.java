package com.pms.dao.idao;

import java.util.List;

public interface IBaseDao<T,K> {
    T findById(K id) throws Exception;

    List<T> findByPage(int page, int size) throws Exception;

    void save(T t) throws Exception;

    void update(T t) throws Exception;

    void delete(T t) throws Exception;
}
