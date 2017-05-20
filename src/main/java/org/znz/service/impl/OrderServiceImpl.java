package org.znz.service.impl;

import org.znz.dto.common.View;
import org.znz.service.OrderService;

import java.util.List;

import static org.znz.helper.Validator.*;

/**
 * Created by zhouxin on 17-5-20.
 */
public class OrderServiceImpl implements OrderService {
    public View createOrderByParams(Integer userId, List<Integer> goodIdList, List<Integer> goodNumberList) {
        try {
            goodIdList = RemoveAllNull(goodIdList);
            goodNumberList = RemoveAllNull(goodNumberList);
            if(goodIdList.size() != goodNumberList.size() || goodIdList.size() == 0) {
                return new View(false, "参数错误");
            }
            return null;

        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
