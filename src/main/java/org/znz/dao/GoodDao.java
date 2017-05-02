package org.znz.dao;

import org.znz.entity.Good;

import java.util.List;

/**
 * Created by zhouxin on 17-5-2.
 */
public interface GoodDao {

    Good queryGoodById(int goodId);

    List<Good> queryGoodsByParams();
}
