package org.znz.service;

import org.znz.dto.common.View;
import org.znz.dto.good.GoodDetail;
import org.znz.dto.good.GoodList;
import org.znz.entity.Good;

/**
 * Created by zhouxin on 17-5-7.
 */
public interface GoodService {

    View<GoodDetail> getGoodById(int goodId);

    View<GoodList> getGoodsByParams(Good good, int page, int size);

    View<GoodDetail> createGoodByParams(Good good);

}
