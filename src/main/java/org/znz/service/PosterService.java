package org.znz.service;

import org.znz.dto.common.View;
import org.znz.entity.Poster;

/**
 * Created by zhangbin on 17-5-20.
 */
public interface PosterService {
    View createPosterByParams(Poster poster);

    View getPostersByParams();

    View deletePosterByParams(Integer posterId);
}
