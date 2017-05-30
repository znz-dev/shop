package org.znz.service;

import org.znz.dto.common.View;
import org.znz.entity.Picture;

public interface PictureService {
    View createPictureByParams(Picture picture);

    View deletePictureById(Integer pictureId);
}
