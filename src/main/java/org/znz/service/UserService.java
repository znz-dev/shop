package org.znz.service;

import org.apache.ibatis.annotations.Param;
import org.znz.dto.user.UserList;
import org.znz.entity.User;

import java.util.List;

/**
 * Created by zhouxin on 17-5-3.
 */
public interface UserService {

    User getUserById(int userId);

//    List<User> getUsersByParams(int offset, int limit);

    UserList getUsersByParams(int offset, int limit);

//    int registerUser();
}
