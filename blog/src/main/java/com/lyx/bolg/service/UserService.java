package com.lyx.bolg.service;

import com.lyx.bolg.pojo.User;

/**
 * Created by liuyixiang  2020-03-18 16:07
 */
public interface UserService {

    User checkUser(String username, String password);

}
