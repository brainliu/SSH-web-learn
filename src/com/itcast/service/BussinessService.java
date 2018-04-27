package com.itcast.service;

import com.itcast.domain.Category;
////
import java.util.List;

public interface BussinessService {
    void addCategory(Category category);
   void updateCategory(Category category);
   void deleteCategory(String categoryID);
    Category findCategory(String categoryID);
    List<Category> finAllCategories();
}
