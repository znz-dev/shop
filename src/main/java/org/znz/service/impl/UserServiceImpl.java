package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.UserDao;
import org.znz.dto.user.UserList;
import org.znz.entity.User;
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

    public UserList getUsersByParams(int offset, int limit) {
        List<User> userList = userDao.queryUsersByParams(offset, limit);
        int count = userDao.queryUsersCountByParams();
        int pages = (count + limit - 1) / limit;

        return new UserList(pages, userList);
    }
}
