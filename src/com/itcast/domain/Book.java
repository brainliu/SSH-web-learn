package com.itcast.domain;

import java.io.Serializable;

public class Book implements Serializable{
    private String id;//主键
    private String name;//书名
    private String author;//作者
    private float money;//单价
    private String description;//描述
    private String path;//存放文件的目录
    private String oldImageName;//原来文件名
    private String newImageName;//新文件名（保证文件不重名）
}
