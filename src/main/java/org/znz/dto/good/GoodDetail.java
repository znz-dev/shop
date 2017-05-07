package org.znz.dto.good;

import org.znz.entity.Good;

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

    public void setGood(Good good) {
        this.good = good;
    }
}
