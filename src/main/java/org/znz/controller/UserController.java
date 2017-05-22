package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.znz.dto.common.View;
import org.znz.dto.message.MessageList;
import org.znz.dto.user.UserDetail;
import org.znz.dto.user.UserList;
import org.znz.entity.Message;
import org.znz.entity.Order;
import org.znz.entity.User;
import org.znz.service.MessageService;
import org.znz.service.OrderService;
import org.znz.service.UserService;

import java.io.File;
import java.io.IOException;


@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private OrderService orderService;

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<UserDetail> show(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if (user == null) {
            return new View<UserDetail>(false, "用户不存在");
        }
        UserDetail userDetail = new UserDetail(user);
        return new View<UserDetail>(userDetail);
    }

    /**
     * 获取所有用户
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<UserList> index(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "6") Integer size,
                                @ModelAttribute User user) {
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 6;
        }
        int offset = (page-1) * size;
        UserList userList = userService.getUsersByParams(user, offset, size);
        return new View<UserList>(userList);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<UserDetail> register(@ModelAttribute User user,
                                     @RequestParam("file") CommonsMultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String rootPath = System.getProperty("shop.webRootPath");
            String filePath = "/upload/picture/avatar/" + file.getOriginalFilename();
            String path = rootPath + filePath;
            file.transferTo(new File(path));
            user.setAvatar(filePath);
        } else {
            user.setAvatar(null);
        }

        return userService.registerUserByParams(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<UserDetail> update(@PathVariable("userId") int userId, @ModelAttribute User user,
                                   @RequestParam("file") CommonsMultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String rootPath = System.getProperty("shop.webRootPath");
            String filePath = "/upload/picture/avatar/" + file.getOriginalFilename();
            String path = rootPath + filePath;
            file.transferTo(new File(path));
            user.setAvatar(filePath);
        } else {
            user.setAvatar(null);
        }
        return userService.updateUserByParams(userId, user);
    }

    @RequestMapping(value = "/{userId}/messageList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<MessageList> messageList(@ModelAttribute Message message,
                                         @PathVariable("userId") int userId,
                                         @RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "size", defaultValue = "6") Integer size) {

        return messageService.getMessagesByParams(message, userId, page, size);
    }

    @RequestMapping(value = "/{userId}/orderList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View orderList(@ModelAttribute Order order,
                          @RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "6") Integer size) {

        return orderService.getOrdersByParams(order, page, size);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View login(@RequestParam(value = "username") String username,
                      @RequestParam(value = "password") String password) {

        return userService.loginUserByParams(username, password);
    }
}
