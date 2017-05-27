package org.znz.dto.user;

import org.znz.entity.User;

import java.util.List;

/**
 * Created by zhangbin on 17-5-5.
 */
public class UserList {
    private int pages;

    private List<User> userList;

    public UserList(int pages, List<User> userList) {
        this.pages = pages;
        this.userList = userList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
