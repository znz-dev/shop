package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.entity.Category;
import org.znz.service.CategoryService;

@CrossOrigin
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View create(@ModelAttribute Category category) {
        return categoryService.createCategoryByParams(category);
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.PUT, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View update(@ModelAttribute Category category) {
        return categoryService.updateCategoryByParams(category);
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View destroy(@PathVariable("categoryId") Integer categoryId) {
        return categoryService.deleteCategoryById(categoryId);
    }

    @RequestMapping(value = "/categoryList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View index() {
        return categoryService.getCategoriesByParams();
    }
}
