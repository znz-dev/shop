package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.FavorDao;
import org.znz.dao.GoodDao;
import org.znz.dao.UserDao;
import org.znz.dto.common.View;
import org.znz.dto.favor.FavorList;
import org.znz.entity.Favor;
import org.znz.entity.Good;
import org.znz.entity.User;
import org.znz.service.FavorService;

import java.util.List;

/**
 * Created by zhouxin on 17-5-20.
 */
@Service
public class FavorServiceImpl implements FavorService {
    @Autowired
    private FavorDao favorDao;

    @Autowired
    private GoodDao goodDao;

    @Autowired
    private UserDao userDao;

    public View createFavorByParams(Favor favor) {
        try {
            Good good = goodDao.queryGoodById(favor.getGoodId());
            User user = userDao.queryUserById(favor.getUserId());
            if(good == null || user == null) {
                return new View(false, "缺少参数");
            }
            int count = favorDao.queryFavorsCount(favor);
            if (count > 0) {
                return new View(false, "您已收藏该商品");
            }

            count = favorDao.createFavorByParams(favor);
            if (count < 1) {
                return new View(false, "收藏失败");
            }
            return new View(true, "收藏成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View deleteFavorById(Integer favorId) {
        try {
            if(favorId == null) {
                return new View(false, "缺少参数");
            }
            int count = favorDao.deleteFavorById(favorId);
            if (count < 1) {
                return new View(false, "删除失败");
            }
            return new View(true, "删除成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View getFavorsByUserId(Integer userId, Integer page, Integer size) {
        try {

            if (page <= 0) {
                page = 1;
            }
            if (size<= 0) {
                size = 6;
            }
            int offset = (page -1)*size;
            List<Favor> favorList = favorDao.queryFavorsByUserId(userId, offset, size);
            int count = favorDao.queryFavorsCountByUserId(userId);
            int pages = (count + size - 1) / size;
            return new View(new FavorList(favorList, pages));
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
