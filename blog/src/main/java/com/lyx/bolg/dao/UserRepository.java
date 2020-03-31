package com.lyx.bolg.dao;

import com.lyx.bolg.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuyixiang  2020-03-18 16:09
 */
public interface UserRepository extends JpaRepository<User,Long> {


    User findByUsernameAndPassword(String username,String password);

}
