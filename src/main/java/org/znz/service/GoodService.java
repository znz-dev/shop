package org.znz.service;

import org.znz.dto.common.View;
import org.znz.dto.good.GoodDetail;
import org.znz.dto.good.GoodList;
import org.znz.entity.Good;

public interface GoodService {

    View<GoodDetail> getGoodById(int goodId);

    View<GoodList> getGoodsByParams(Good good, int page, int size);

    View<GoodDetail> createGoodByParams(Good good);

    View deleteGoodById(int goodId);

    View<GoodDetail> updateGoodByParams(int goodId, Good good);

}
