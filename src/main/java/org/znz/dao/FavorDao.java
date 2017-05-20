package org.znz.dao;

import org.znz.entity.Favor;

import java.util.List;

public interface FavorDao {
    int createFavorByParams(Favor favor);

    int deleteFavorById(Integer favorId);

    List<Favor> queryFavorsByUserId(Integer userId);

    int queryFavorsCount(Favor favor);
}
