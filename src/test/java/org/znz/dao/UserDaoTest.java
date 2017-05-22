package org.znz.dao;

import com.alibaba.druid.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.znz.entity.Poster;
import org.znz.entity.User;
import org.znz.helper.Validator;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.znz.helper.Validator.RemoveAllNull;

/**
 * Created by zhouxin on 17-5-2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Resource
    private PosterDao posterDao;

    @Test
    public void queryUserById() throws Exception {
        int id = 1;
        User user = userDao.queryUserById(id);
        System.out.println(user.getClass());
        System.out.println(user);
    }

    @Test
    public void queryUsersByParams() throws Exception {
        User user1 = new User();
        user1.setUsername("lalala");
        List<User> userList = userDao.queryUsersByParams(user1, 0, 1);
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

    @Test
    public void updateUserByParams() throws Exception {
        User user = new User();
        user.setPassword("lalala");
        user.setUserId(1000);
        int count = userDao.updateUserByParams(user);
        System.out.println(count);
    }

    @Test
    public void dddccc() throws Exception {
        List<Integer> a = new ArrayList<Integer>(10);
        a.add(7);
        a.add(2);
        a.add(null);
        a.add(14);
        a.add(null);
        a.add(15);
//        List<Integer> e = new ArrayList<Integer>(1);
//        e.add(null);
//        a.removeAll(e);
        a = RemoveAllNull(a);
        System.out.println(a.size());
        System.out.println(a);
        for(int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    @Test
    public void createOrder() throws Exception {
        Poster poster = new Poster();
        poster.setPicture("342342");
        poster.setGoodId(1);
        System.out.println(poster.getPosterId());
        posterDao.createPosterByParams(poster);
        System.out.println(poster.getPosterId());
    }

}