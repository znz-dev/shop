package org.znz.dto.poster;


import org.znz.entity.Poster;

import java.util.List;

public class PosterList {
    private List<Poster> posterList;

    public PosterList(List<Poster> posterList) {
        this.posterList = posterList;
    }

    public List<Poster> getPosterList() {

        return posterList;
    }

    public void setPosterList(List<Poster> posterList) {
        this.posterList = posterList;
    }
}
