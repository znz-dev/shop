package org.znz.dto.category;

import org.znz.entity.Category;

import java.util.List;

public class CategoryList {
    private List<Category> categoryList;

    public CategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {

        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
