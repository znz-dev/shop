package org.znz.service;

import org.znz.dto.common.View;
import org.znz.dto.user.UserDetail;
import org.znz.dto.user.UserList;
import org.znz.entity.User;

import java.util.List;

/**
 * Created by zhouxin on 17-5-3.
 */
public interface UserService {

    User getUserById(int userId);

//    List<User> getUsersByParams(int offset, int limit);

    UserList getUsersByParams(User user, int offset, int limit);

    View<UserDetail> registerUserByParams(User user);
//
    View<UserDetail> updateUserByParams(int userId, User user);
}
