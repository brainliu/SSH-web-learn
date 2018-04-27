package com.itcast.dao;

import com.itcast.domain.Category;

import java.util.List;

public interface CategoryDao {
    void add(Category category);

    void update(Category category);

    void delete(String categoryID);
    Category find(String categoryID);
    List<Category> findAll();
}
