package org.znz.service;

import org.znz.dto.common.View;
import org.znz.entity.Category;

/**
 * Created by zhouxin on 17-5-20.
 */
public interface CategoryService {
    View createCategoryByParams(Category category);

    View updateCategoryByParams(Category category);

    View deleteCategoryById(Integer categoryId);

    View getCategoriesByParams();
}
