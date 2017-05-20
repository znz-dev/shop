package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.PosterDao;
import org.znz.dto.common.View;
import org.znz.dto.poster.PosterList;
import org.znz.entity.Poster;
import org.znz.service.PosterService;

@Service
public class PosterServiceImpl implements PosterService {
    @Autowired
    private PosterDao posterDao;

    public View createPosterByParams(Poster poster) {
        try {
            int count;
            count = posterDao.createPosterByParams(poster);
            if (count <= 0) {
                return new View(false, "插入失败");
            }
            return new View(true, "插入成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View getPostersByParams() {
        try {
            PosterList posterList = new PosterList(posterDao.queryPostersByParams());
            return new View(posterList);
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View deletePosterByParams(Integer posterId) {
        try {
            int count;
            count = posterDao.deletePosterById(posterId);
            if (count <= 0) {
                return new View(false, "删除失败");
            }
            return new View(true, "删除成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
