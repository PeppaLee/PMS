package com.pms.service.impl;

import com.pms.commons.Const;
import com.pms.commons.ResResult;
import com.pms.dao.idao.IUserDao;
import com.pms.dao.pojo.User;
import com.pms.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;


    @Override
    public ResResult<User> login(String username, String password) {
       ResResult<User> result = null;
        try {
            result = userDao.login(username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String userExist(String username) {
        String msg = Const.ERROR;
        try {
            msg = userDao.userExist(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }


    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findByPage(int page, int size) {
        return null;
    }

    @Override
    public String save(User user) {
        return null;
    }

    @Override
    public String update(User user) {
        return null;
    }

    @Override
    public String delete(User user) {
        return null;
    }
}
