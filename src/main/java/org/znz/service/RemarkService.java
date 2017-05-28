package org.znz.service;

import org.znz.dto.common.View;
import org.znz.entity.Remark;

public interface RemarkService {
    View createRemarkByParams(Remark remark);

    View getRemarksByParamsByGoodId(Integer goodId, Integer page, Integer size);
}
