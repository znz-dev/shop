package org.znz.dto.user;

import org.znz.entity.User;

/**
 * Created by zhangbin on 17-5-5.
 */
public class UserDetail {
    private User user;

    public UserDetail(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
