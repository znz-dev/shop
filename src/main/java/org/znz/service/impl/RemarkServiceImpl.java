package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.RemarkDao;
import org.znz.dto.common.View;
import org.znz.dto.remark.RemarkList;
import org.znz.entity.Remark;
import org.znz.service.RemarkService;

import java.util.List;

@Service
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    private RemarkDao remarkDao;

    public View createRemarkByParams(Remark remark) {
        try {
            int count = 0;
            count = remarkDao.createRemarkByParams(remark);
            if (count == 0) {
                return new View(false, "插入失败");
            }
            return new View(true, "插入成功");

        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View getRemarksByParamsByGoodId(Integer goodId, Integer page, Integer size) {
        if (page <= 0) {
            page = 1;
        }
        if (size<= 0) {
            size = 6;
        }
        int offset = (page -1)*size;
        try {
            List<Remark> remarkList = remarkDao.queryRemarksByGoodId(goodId, offset, size);
            int count = remarkDao.queryRemarkCountByGoodId(goodId);
            int pages = (count + size - 1) / size;
            return new View(new RemarkList(pages, remarkList));
        } catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
