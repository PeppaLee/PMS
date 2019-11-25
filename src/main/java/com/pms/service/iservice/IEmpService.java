package com.pms.service.iservice;

import com.pms.dao.pojo.Emp;

import java.util.List;

public interface IEmpService extends IBaseService<Emp,Integer> {
    List<Emp> findByName(String name);

    List<Emp> findAll() ;

//    Emp showInfoByEname(String ename) throws Exception;
}
