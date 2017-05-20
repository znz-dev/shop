package org.znz.service;

import org.znz.dto.common.View;

import java.util.List;

/**
 * Created by zhouxin on 17-5-20.
 */
public interface OrderService {
    View createOrderByParams(Integer userId, List<Integer> goodIdList, List<Integer> goodNumberList);
}
