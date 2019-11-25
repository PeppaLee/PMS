package com.pms.service.iservice;

import com.pms.commons.ResResult;
import com.pms.dao.pojo.User;

public interface IUserService extends IBaseService<User, Integer> {
    ResResult<User> login(String username, String password);

    String userExist(String username);
}
