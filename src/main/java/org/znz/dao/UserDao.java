package org.znz.dao;

import org.znz.entity.User;

/**
 * Created by zhouxin on 17-5-1.
 */
public interface UserDao {

    User queryUserById(int userId);

    int updateUserByParams(int userId);


}
