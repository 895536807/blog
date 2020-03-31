package com.lyx.bolg.service.impl;

import com.lyx.bolg.dao.UserRepository;
import com.lyx.bolg.pojo.User;
import com.lyx.bolg.service.UserService;
import com.lyx.bolg.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuyixiang  2020-03-18 16:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {

        User user = this.userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
