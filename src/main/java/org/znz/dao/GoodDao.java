package org.znz.dao;

import org.apache.ibatis.annotations.Param;
import org.znz.entity.Good;

import java.util.List;

/**
 * Created by zhouxin on 17-5-2.
 */
public interface GoodDao {

    int createGoodByParams(Good good);

    Good queryGoodById(int goodId);

    List<Good> queryGoodsByParams(@Param("good") Good good, @Param("offset") int offset, @Param("limit") int limit);
    int queryGoodsCountByParams(@Param("good") Good good);
}
