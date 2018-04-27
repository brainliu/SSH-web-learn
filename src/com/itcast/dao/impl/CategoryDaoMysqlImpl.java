package com.itcast.dao.impl;

import com.itcast.dao.CategoryDao;
import com.itcast.dao.DBCPUtil.DBCPUtil;
import com.itcast.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoMysqlImpl implements CategoryDao {
    private QueryRunner qr=new QueryRunner(DBCPUtil.getdataSource("dbcpconfig.properties"));
    @Override
    public void add(Category category) {
        if(category==null)
            throw new IllegalArgumentException("the param category  can not be null");
        try {
            qr.update("insert into category (id,name,description) values (?,?,?)",
                    category.getId(),category.getName(),category.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("执行sql语句失败");
        }
    }

    @Override
    public void update(Category category) {
        if(category==null)
            throw new IllegalArgumentException("the param category  can not be null");
        try {
            qr.update("update category set name=?,description=? where id=?",category.getName(),
                    category.getDescription(),category.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("执行sql语句失败");
        }
    }

    @Override
    public void delete(String categoryID) {
        if(categoryID==null||categoryID.trim().equals(""))
            throw new IllegalArgumentException("The param categoryId can not be empty");
        try {
            qr.update("delete from category where id=?",categoryID);
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }

    }


    @Override
    public Category find(String categoryId) {
        if(categoryId==null||categoryId.trim().equals(""))
            throw new IllegalArgumentException("The param categoryId can not be empty");
        try {
            return qr.query("select * from category where id=?", new BeanHandler<Category>(Category.class),
                    categoryId);
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败");
        }
    }


    @Override
    public List<Category> findAll() {
        try {
            return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("执行SQL语句失败");
        }
    }
}
