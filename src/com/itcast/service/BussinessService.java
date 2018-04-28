package com.itcast.service;

import com.itcast.domain.Book;
import com.itcast.domain.Category;
import com.itcast.web.bean.Page;
////
import java.util.List;

public interface BussinessService {
    void addCategory(Category category);
   void updateCategory(Category category);
   void deleteCategory(String categoryID);
    Category findCategory(String categoryID);
    List<Category> finAllCategories();
    void addBook(Book book);
    void update(Book book);
    void deleteBook(String Bookid);
    Book findBookByid(String bookin);
    Page FindPageBook(String num);
    Page findPageBook(String num,String categoryId);

}
