package com.itcast.service.impl;

import com.itcast.dao.CategoryDao;
import com.itcast.dao.impl.CategoryDaoMysqlImpl;
import com.itcast.domain.Category;
import com.itcast.service.BussinessService;

import java.util.List;
import java.util.UUID;

public class BusinessServiceImpl implements BussinessService {
    private CategoryDao categoryDao=new CategoryDaoMysqlImpl();
    @Override
    public void addCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        categoryDao.add(category);

    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void deleteCategory(String categoryID) {
        categoryDao.delete(categoryID);
    }

    @Override
    public Category findCategory(String categoryID) {
        return categoryDao.find(categoryID);
    }

    @Override
    public List<Category> finAllCategories() {
        return categoryDao.findAll();
    }
}
