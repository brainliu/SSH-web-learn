package com.itcast.service.impl;

import com.itcast.dao.BookDao;
import com.itcast.dao.CategoryDao;
import com.itcast.dao.impl.BookDaoMysqlimpl;
import com.itcast.dao.impl.CategoryDaoMysqlImpl;
import com.itcast.domain.Book;
import com.itcast.domain.Category;
import com.itcast.service.BussinessService;
import com.itcast.web.bean.Page;

import java.util.List;
import java.util.UUID;

public class BusinessServiceImpl implements BussinessService {
    private CategoryDao categoryDao=new CategoryDaoMysqlImpl();
    private BookDao bookDao=new BookDaoMysqlimpl();
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

    @Override
    public void addBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        bookDao.save(book);
    }

    @Override
    public void update(Book book) {
        throw new AbstractMethodError("木有实现");
    }

    @Override
    public void deleteBook(String Bookid) {
        throw new AbstractMethodError("木有实现");
    }

    @Override
    public Book findBookByid(String bookid) {
        return bookDao.findbyId(bookid);
    }

    @Override
    public Page FindPageBook(String num) {
        int pageNum=1;
        if(num!=null&&!num.equals("")){
            pageNum=Integer.parseInt(num);
        }
        int totalRecords=bookDao.findRecordNum();
        Page page=new Page(pageNum,totalRecords);
        List<Book> records=bookDao.findpageRecords(page.getStartindex(),page.getPagesize());
        page.setRecords(records);
        return page;
    }



    @Override
    public Page findPageBook(String num, String categoryId) {
        int pageNum=1;
        if(num!=null&&!num.equals("")){
            pageNum=Integer.parseInt(num);
        }
        int totalRecords=bookDao.findRecordNum(categoryId);
        Page page=new Page(pageNum,totalRecords);
        List<Book> records=bookDao.findpageRecords(page.getStartindex(),page.getPagesize(),categoryId);
        page.setRecords(records);
        return page;
    }
}
