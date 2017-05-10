//package org.znz.dao;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
////import org.znz.entity.Shop;
//
//import javax.annotation.Resource;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by zhouxin on 17-5-2.
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/spring-dao.xml"})
//public class ShopDaoTest {
//
//    @Resource
//    private ShopDao shopDao;
//
//
//    @Test
//    public void queryShopById() throws Exception {
//        Shop shop = shopDao.queryShopById(1);
//        System.out.println(shop.getClass());
//        System.out.println(shop);
//    }
//
//    @Test
//    public void queryShopsByParams() throws Exception {
//        List<Shop> shopList = shopDao.queryShopsByParams();
//        for(Shop shop : shopList) {
//            System.out.println(shop.getClass());
//            System.out.println(shop);
//        }
//    }
//
//}