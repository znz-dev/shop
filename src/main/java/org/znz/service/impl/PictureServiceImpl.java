package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.PictureDao;
import org.znz.dto.common.View;
import org.znz.entity.Picture;
import org.znz.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    public View createPictureByParams(Picture picture) {
        try {
            int count;
            count = pictureDao.createPictureByParams(picture);
            if (count <= 0) {
                return new View(false, "插入失败");
            }
            return new View(true, "插入成功");
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View deletePictureById(Integer pictureId) {
        try {
            int count;
            count = pictureDao.deletePictureById(pictureId);
            if (count <= 0) {
                return new View(false, "删除失败");
            }
            return new View(true, "删除成功");
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
