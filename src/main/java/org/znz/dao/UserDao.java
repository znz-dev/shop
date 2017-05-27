package org.znz.dao;

import org.apache.ibatis.annotations.Param;
import org.znz.entity.User;

import java.util.List;

/**
 * Created by zhangbin on 17-5-1.
 */
public interface UserDao {

    int insertUserByParams(User user);

    User queryUserById(int userId);

    User queryUserByName(String username);

//    User queryUserByUsername(String username);

    List<User> queryUsersByParams(@Param("user") User user, @Param("offset") int offset, @Param("limit") int limit);

    int queryUsersCountByParams(@Param("user") User user);

    int updateUserByParams(User user);

}
