package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.znz.dto.common.View;
import org.znz.dto.user.UserDetail;
import org.znz.dto.user.UserList;
import org.znz.entity.User;
import org.znz.service.UserService;

import javax.xml.soap.Detail;
import java.util.List;

/**
 * Created by zhouxin on 17-5-4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<UserDetail> show(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if (user == null) {
            return new View<UserDetail>("用户不存在");
        }
        UserDetail userDetail = new UserDetail(user);
        return new View<UserDetail>(userDetail);
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<UserList> index(Integer page, Integer size) {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 6;
        }
        int offset = (page-1) * size;
        UserList userList = userService.getUsersByParams(offset, size);


        return new View<UserList>(userList);

    }
}
