package com.itcast.dao.DBCPUtil;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtil {
    private static DataSource datasource;
    static {
        InputStream in =DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
        Properties props=new Properties();
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            datasource= BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }

    }

    public static DataSource getdataSource(String s) {
        return datasource;
    }
    public  static Connection getconnection(){
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("从数据源获取连接失败");
        }
    }
}

