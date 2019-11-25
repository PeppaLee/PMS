package com.pms.service.iservice;

import java.util.List;

public interface IBaseService<T,K> {
    T findById(K id);

    List<T> findByPage(int page, int size);

    String save(T t);

    String update(T t);

    String delete(T t);
}
