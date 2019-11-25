package com.pms.dao.idao;

import com.pms.commons.ResResult;
import com.pms.dao.pojo.User;

public interface IUserDao extends IBaseDao<User,Integer> {
   ResResult<User> login(String username, String password) throws Exception;
    String userExist(String username) throws Exception;
}
