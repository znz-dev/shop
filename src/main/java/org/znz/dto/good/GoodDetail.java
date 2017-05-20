package org.znz.dto.good;

import org.znz.entity.Custom;
import org.znz.entity.Good;

import java.util.List;

/**
 * Created by zhouxin on 17-5-7.
 */
public class GoodDetail {
    private Good good;

    public GoodDetail(Good good) {
        this.good = good;
    }

    public Good getGood() {
        return good;
    }

    public List<Custom> customList;

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
