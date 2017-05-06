package org.znz.dao;

import com.alibaba.druid.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.znz.entity.User;
import org.znz.helper.Validator;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhouxin on 17-5-2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void queryUserById() throws Exception {
        int id = 1;
        User user = userDao.queryUserById(id);
        System.out.println(user.getClass());
        System.out.println(user);
    }

    @Test
    public void queryUsersByParams() throws Exception {
        List<User> userList = userDao.queryUsersByParams(0, 1);
        for(User user : userList) {
            System.out.println(user.getClass());
            System.out.println(user);
        }
    }

    @Test
    public void emptyTest(){
        String a = "   dfsf dfadsf  ";
        String b = "fasfa";
        String c = "  fda ";
        String[] userParams = {a, b, c};
        System.out.println(Validator.blank(userParams));
        System.out.println(a);
    }

}