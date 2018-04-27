package com.itcast.test;

import com.itcast.domain.Category;
import com.itcast.service.BussinessService;
import com.itcast.service.impl.BusinessServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BusinessServiceImplTest {
    private BussinessService s=new BusinessServiceImpl();

    @Test
    public void testaddCategory() {
        Category category = new Category();
//        category.setId("1");
        category.setName("Java编程类");
        category.setDescription("走向高富帅的入口");
        s.addCategory(category);
    }

    @Test
    public void updateCategory() {
        Category c = s.findCategory("a8b1b83e-e9c3-41ba-9244-c4dad297122a");
        c.setDescription("走向高富帅的摇篮");
        s.updateCategory(c);
    }

    @Test
    public void deleteCategory() {
        s.deleteCategory("a8b1b83e-e9c3-41ba-9244-c4dad297122a");
    }

    @Test
    public void findCategory() {
        Category c = s.findCategory("0a6de2f3-5740-421f-b36d-38e996b91786");
        System.out.println(c.getName());
    }

    @Test
    public void finAllCategories() {
        List<Category> cs = s.finAllCategories();
        for(Category c:cs)
            System.out.println(c.getName());
    }
}