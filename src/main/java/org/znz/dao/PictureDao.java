package org.znz.dao;

import org.znz.entity.Picture;

import java.util.List;

public interface PictureDao {
    int createPictureByParams(Picture picture);

    int deletePictureById(Integer pictureId);

    List<Picture> queryPicturesByGoodId(Integer goodId);
}
