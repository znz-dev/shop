package org.znz.dao;

import org.apache.ibatis.annotations.Param;
import org.znz.entity.Favor;

import java.util.List;

public interface FavorDao {
    int createFavorByParams(Favor favor);

    int deleteFavorById(Integer favorId);

    List<Favor> queryFavorsByUserId(@Param("userId") Integer userId, @Param("offset") Integer offset,
                                    @Param("limit") Integer limit);

    int queryFavorsCountByUserId(Integer userId);

    int queryFavorsCount(Favor favor);
}
