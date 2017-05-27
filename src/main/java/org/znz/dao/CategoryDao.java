package org.znz.dao;

import org.znz.entity.Category;

import java.util.List;

/**
 * Created by zhangbin on 17-5-20.
 */
public interface CategoryDao {
    int createCategoryByParams(Category category);

    List<Category> queryCategoriesByParams();

    int updateCategoryByParams(Category category);

    int deleteCategoryById(Integer categoryId);

}
