package com.pms.service.impl;

import com.pms.commons.Const;
import com.pms.dao.idao.IEmpDao;
import com.pms.dao.pojo.Emp;
import com.pms.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDao empDao;

    @Override
    public List<Emp> findByName(String name) {
        List<Emp> empList = null;
        try {
            empList = empDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }

    @Override
    public List<Emp> findAll()  {
        List<Emp> empList = null;
        try {
            empList = empDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = null;
        try {
            emp = empDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp> empList = null;
        try {
            empList = empDao.findByPage(page, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }

    @Override
    public String save(Emp t) {
        String msg = Const.ERROR;
        try {
            empDao.save(t);
            msg = Const.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String update(Emp t) {
        String msg = Const.ERROR;
        try {
            empDao.update(t);
            msg = Const.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String delete(Emp t) {
        String msg = Const.ERROR;
        try {
            empDao.delete(t);
            msg = Const.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
