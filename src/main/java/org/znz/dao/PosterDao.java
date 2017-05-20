package org.znz.dao;

import org.znz.entity.Poster;

import java.util.List;

/**
 * Created by zhouxin on 17-5-20.
 */
public interface PosterDao {
    int createPosterByParams(Poster poster);

//    int updatePosterByParams(Poster poster);

    int deletePosterById(Integer posterId);

    List<Poster> queryPostersByParams();
}
