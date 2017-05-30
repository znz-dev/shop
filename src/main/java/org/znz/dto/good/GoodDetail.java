package org.znz.dto.good;

import org.znz.entity.Custom;
import org.znz.entity.Good;
import org.znz.entity.Picture;

import java.util.List;

public class GoodDetail {
    private Good good;

    public List<Custom> customList;

    public List<Picture> pictureList;

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public GoodDetail(Good good) {
        this.good = good;
    }

    public Good getGood() {
        return good;
    }

    public List<Custom> getCustomList() {
        return customList;
    }

    public void setCustomList(List<Custom> customList) {
        this.customList = customList;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
