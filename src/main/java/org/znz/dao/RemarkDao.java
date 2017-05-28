package org.znz.dao;

import org.apache.ibatis.annotations.Param;
import org.znz.entity.Remark;

import java.util.List;

public interface RemarkDao {
    int createRemarkByParams(Remark remark);

    List<Remark> queryRemarksByGoodId(@Param("goodId") Integer goodId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    int queryRemarkCountByGoodId(Integer goodId);
}
