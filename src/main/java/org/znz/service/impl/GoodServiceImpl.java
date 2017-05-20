package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.CustomDao;
import org.znz.dao.GoodDao;
import org.znz.dto.common.View;
import org.znz.dto.good.GoodDetail;
import org.znz.dto.good.GoodList;
import org.znz.entity.Custom;
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

    @Autowired
    private CustomDao customDao;

    public View<GoodDetail> getGoodById(int goodId) {
        Good good = goodDao.queryGoodById(goodId);
        if (good == null) {
            return new View<GoodDetail>(false, "不存在该商品");
        }
        List<Custom> customList = customDao.queryCustomsByGoodId(goodId);
        GoodDetail goodDetail = new GoodDetail(good);
        goodDetail.setCustomList(customList);
        return new View<GoodDetail>(goodDetail);
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
            return new View<GoodDetail>(true, "插入成功");
        } catch (Exception e) {
            return new View<GoodDetail>(false, e.getMessage());
        }
    }

    public View deleteGoodById(int goodId) {
        try {
            int count;
            count = goodDao.deleteGoodById(goodId);
            if (count <= 0) {
                return new View<GoodDetail>(false, "删除失败");
            }
            return new View(true, "删除成功");
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View updateGoodByParams(int goodId, Good good) {
        good.setGoodId(goodId);
        try {
            int count;
            count = goodDao.updateGoodByParams(good);
            if (count <= 0) {
                return new View(false, "更新失败");
            }
            GoodDetail goodDetail = new GoodDetail(goodDao.queryGoodById(goodId));
            return new View<GoodDetail>(goodDetail);
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

}
