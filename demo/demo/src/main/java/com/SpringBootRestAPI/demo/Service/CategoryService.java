package com.SpringBootRestAPI.demo.Service;


import com.SpringBootRestAPI.demo.Entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(int id);
    void deleteCategory(int id);
}
