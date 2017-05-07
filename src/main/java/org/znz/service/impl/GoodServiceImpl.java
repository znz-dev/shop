package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.GoodDao;
import org.znz.dto.common.View;
import org.znz.dto.good.GoodDetail;
import org.znz.dto.good.GoodList;
import org.znz.entity.Good;
import org.znz.service.GoodService;

import java.util.List;

/**
 * Created by zhouxin on 17-5-7.
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    public View<GoodDetail> getGoodById(int goodId) {
        Good good = goodDao.queryGoodById(goodId);
        if (good == null) {
            return new View<GoodDetail>(false, "不存在该商品");
        }
        return new View<GoodDetail>(new GoodDetail(good));
    }

    public View<GoodList> getGoodsByParams(Good good, int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        if (size<= 0) {
            size = 6;
        }
        int offset = (page -1)*size;
        try {
            List<Good> goodList = goodDao.queryGoodsByParams(good, offset, size);
            int count = goodDao.queryGoodsCountByParams(good);
            int pages = (count + size - 1) / size;
            return new View<GoodList>(new GoodList(pages, goodList));
        } catch (Exception e) {
            return new View<GoodList>(false, e.getMessage());
        }
    }

    public View<GoodDetail> createGoodByParams(Good good) {

        try {
            int count;
            count = goodDao.createGoodByParams(good);
            if (count <= 0) {
                return new View<GoodDetail>(false, "插入失败");
            }
            //TODO 判断新增的商品是否属于某一个店铺
            return new View<GoodDetail>(true, "插入成功");
        } catch (Exception e) {
            return new View<GoodDetail>(false, e.getMessage());
        }
    }

}
