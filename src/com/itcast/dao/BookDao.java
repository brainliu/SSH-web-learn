package com.itcast.dao;

import com.itcast.domain.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);
    Book findbyId(String  bookId);
    int findRecordNum();
    List<Book> findpageRecords(int startindex, int pagesize);
    int findRecordNum(String categoryID);
    List<Book>   findpageRecords(int startindex, int pageSzie,String catgoryID);
}
