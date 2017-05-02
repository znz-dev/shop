package org.znz.dao;

import org.znz.entity.User;

import java.util.List;

/**
 * Created by zhouxin on 17-5-1.
 */
public interface UserDao {

    User queryUserById(int userId);

    List<User> queryUsersByParams();

}
