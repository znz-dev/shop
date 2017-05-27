package org.znz.service;

import org.znz.dto.common.View;
import org.znz.entity.Favor;

/**
 * Created by zhangbin on 17-5-20.
 */
public interface FavorService {
    View createFavorByParams(Favor favor);

    View deleteFavorById(Integer favorId);

    View getFavorsByUserId(Integer userId, Integer page, Integer size);
}
