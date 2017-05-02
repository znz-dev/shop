package org.znz.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.znz.entity.Good;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhouxin on 17-5-2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class GoodDaoTest {
    @Resource
    GoodDao goodDao;

    @Test
    public void queryGoodById() throws Exception {
        Good good = goodDao.queryGoodById(10000);
        System.out.println(good.getClass());
        System.out.println(good);
    }

    @Test
    public void queryGoodsByParams() throws Exception {
        List<Good> goodList = goodDao.queryGoodsByParams();
        for(Good good : goodList) {
            System.out.println(good.getClass());
            System.out.println(good);
        }
    }

}