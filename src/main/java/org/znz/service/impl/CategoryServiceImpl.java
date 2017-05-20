package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.CategoryDao;
import org.znz.dto.category.CategoryList;
import org.znz.dto.common.View;
import org.znz.entity.Category;
import org.znz.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public View createCategoryByParams(Category category) {
        try {
            int count;
            count = categoryDao.createCategoryByParams(category);
            if (count <= 0) {
                return new View(false, "插入失败");
            }
            return new View(true, "插入成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View updateCategoryByParams(Category category) {
        try {
            int count;
            count = categoryDao.updateCategoryByParams(category);
            if (count <= 0) {
                return new View(false, "更新失败");
            }
            return new View(true, "更新成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View deleteCategoryById(Integer categoryId) {
        try {
            int count;
            count = categoryDao.deleteCategoryById(categoryId);
            if (count <= 0) {
                return new View(false, "删除失败");
            }
            return new View(true, "删除成功");
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

    public View getCategoriesByParams() {
        try {
            CategoryList categoryList = new CategoryList(categoryDao.queryCategoriesByParams());
            return new View(categoryList);
        } catch(Exception e) {
            return new View(false, e.getMessage());
        }
    }

}
