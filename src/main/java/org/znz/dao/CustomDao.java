package org.znz.dao;

import org.znz.entity.Custom;

import java.util.List;

/**
 * Created by zhouxin on 17-5-20.
 */
public interface CustomDao {
    int createCustomByParams(Custom custom);

    int updateCustomByParams(Custom custom);

    int deleteCustromByParams(Integer customId);

    List<Custom> queryCustomsByGoodId(Integer goodId);

    Custom queryCustomById(Integer customId);

}
