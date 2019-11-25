package com.pms.dao.impl;

import com.pms.commons.Const;
import com.pms.commons.ResResult;
import com.pms.dao.idao.IUserDao;
import com.pms.dao.pojo.User;
import com.pms.dao.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements IUserDao {


    @Override
    public ResResult<User> login(String username, String password) throws Exception {
        ResResult<User> result = null;
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select userid,username,pri from t_user where username=? and password=md5(?)";
        User user = qr.query(sql, new BeanHandler<User>(User.class), username, password);
        if(user!=null){
            result = new ResResult<User>(200,"login success");
        }else{
            result = new ResResult<User>(404,"login error");
        }
        return result;
    }

    @Override
    public String userExist(String username) throws Exception {
        QueryRunner qr = DBUtils.getQueryRunner();
        String sql = "select username from t_user where username=?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), username);
        return user != null ? Const.SUCCESS : Const.ERROR;
    }

    @Override
    public User findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<User> findByPage(int page, int size) throws Exception {
        return null;
    }

    @Override
    public void save(User user) throws Exception {

    }

    @Override
    public void update(User user) throws Exception {

    }

    @Override
    public void delete(User user) throws Exception {

    }
}
