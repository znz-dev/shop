package org.znz.service.impl;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.UserDao;
import org.znz.dto.common.View;
import org.znz.dto.user.UserDetail;
import org.znz.dto.user.UserList;
import org.znz.entity.User;
import org.znz.helper.Validator;
import org.znz.service.UserService;

import java.util.List;

/**
 * Created by zhouxin on 17-5-4.
 */
@Service
public class UserServiceImpl implements UserService {

//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    public User getUserById(int userId) {
        return userDao.queryUserById(userId);
    }

    public UserList getUsersByParams(User user, int offset, int limit) {
        List<User> userList = userDao.queryUsersByParams(user, offset, limit);
        int count = userDao.queryUsersCountByParams(user);
        int pages = (count + limit - 1) / limit;

        return new UserList(pages, userList);
    }

    public View<UserDetail> registerUserByParams(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String[] mustParams = {username, password};
        if (Validator.blank(mustParams)) {
            return new View<UserDetail>(false, "缺少参数");
        }

        if (userDao.queryUserByName(user.getUsername()) != null){
            return new View<UserDetail>(false, "用户名已存在");
        }

        try {
            userDao.insertUserByParams(user);
        } catch (Exception e) {
            return new View<UserDetail>(false, e.getMessage());
        }
        user = userDao.queryUserByName(username);
        return new View<UserDetail>(new UserDetail(user));
    }

    public View<UserDetail> updateUserByParams(int userId, User user) {
        user.setUserId(userId);
        if (userDao.queryUserById(userId) == null) {
            return new View<UserDetail>(false, "用户不存在");
        }

        try {
            int count = userDao.updateUserByParams(user);
            if (count == 0) {
                return new View<UserDetail>(false, "更新失败");
            }
            user = userDao.queryUserById(userId);
            return new View<UserDetail>(new UserDetail(user));
        } catch (Exception e) {
            return new View<UserDetail>(false, e.getMessage());
        }

    }

    public View<UserDetail> loginUserByParams(String username, String password) {
        try {
            User user = userDao.queryUserByName(username);
            if (user == null) {
                return new View(false, "用户名不存在");
            }
            if (!user.getPassword().equals(password)) {
                return new View(false, "密码错误");
            }
            return new View<UserDetail>(new UserDetail(user));
        } catch (Exception e) {
            return new View<UserDetail>(false, e.getMessage());
        }
    }
}
