package com.pms.dao.idao;

import com.pms.dao.pojo.Emp;

import java.util.List;

public interface IEmpDao extends IBaseDao<Emp,Integer> {
    List<Emp> findByName(String name) throws Exception;

    List<Emp> findAll() throws Exception;

//    Emp showInfoByEname(String ename) throws Exception;
}
