package org.znz.dto.favor;

import org.znz.entity.Favor;

/**
 * Created by zhouxin on 17-5-20.
 */
public class FavorDetail {
    private Favor favor;

    public FavorDetail(Favor favor) {
        this.favor = favor;
    }

    public Favor getFavor() {

        return favor;
    }

    public void setFavor(Favor favor) {
        this.favor = favor;
    }
}
