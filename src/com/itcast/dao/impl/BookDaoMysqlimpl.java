package com.itcast.dao.impl;

import com.itcast.DBCPUtil.DBCPUtil;
import com.itcast.dao.BookDao;
import com.itcast.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoMysqlimpl implements BookDao{
    private QueryRunner qr=new QueryRunner(DBCPUtil.getdataSource());
    @Override
    public void save(Book book) {

        try {
            qr.update("insert into book values(?,?,?,?,?,?,?,?,?)",book.getId(),book.getName(),book.getAuthor(),
                    book.getMoney(),book.getDescription(),book.getPath(),
                    book.getOldImageName(),book.getNewImageName(),book.getCategoryId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findbyId(String bookId) {
        try {
            return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class), bookId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    /*
    *
    * 查询所有的记录的条数
    * */
    @Override
    public int findRecordNum() {
        try {
            Object obj = qr.query("select count(*) from book", new ScalarHandler(1));
            if(obj instanceof Long)
            {
                return ((Long)obj).intValue();
            }else if(obj instanceof Integer){
                return(Integer)obj;
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Book> findpageRecords(int startindex, int pagesize) {
        try {
            return qr.query("select * from book order by categoryId limit ?,?", new BeanListHandler<Book>(Book.class), startindex,pagesize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findRecordNum(String categoryID) {
        try {
            Object obj = qr.query("select count(*) from book where categoryId=?", new ScalarHandler(1),categoryID);
            if(obj instanceof Long)
            {
                return ((Long)obj).intValue();
            }else if(obj instanceof Integer){
                return(Integer)obj;
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> findpageRecords(int startindex, int pageSzie, String catgoryID) {
        try {
            return qr.query("select * from book where categoryId=? limit ?,?", new BeanListHandler<Book>(Book.class),catgoryID, startindex,pageSzie);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
