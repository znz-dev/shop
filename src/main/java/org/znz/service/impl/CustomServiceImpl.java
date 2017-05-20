package org.znz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.CustomDao;
import org.znz.dto.common.View;
import org.znz.entity.Custom;
import org.znz.service.CustomService;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomDao customDao;

    public View createCustomByParams(Integer goodId, Custom custom) {
        try {
            custom.setGoodId(goodId);
            int count = 0;
            count = customDao.createCustomByParams(custom);
            if (count <= 0) {
                return new View(false, "插入失败");
            }
            return new View(true, "插入成功");
        }catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View updateCustomByParams(Integer customId, Custom custom) {
        try {
            custom.setGoodId(customId);
            int count;
            count = customDao.updateCustomByParams(custom);
            if (count <= 0) {
                return new View(false, "更新失败");
            }
            return new View(true, "更新成功");
        }catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View deleteCustomById(Integer customId) {
        try {
            int count;
            count = customDao.deleteCustromByParams(customId);
            if (count <= 0) {
                return new View(false, "删除失败");
            }
            return new View(true, "删除成功");
        }catch (Exception e) {
            return new View(false, e.getMessage());
        }
    }
}
