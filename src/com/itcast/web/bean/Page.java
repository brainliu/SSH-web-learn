package com.itcast.web.bean;

import java.util.List;

public class Page {
    private List records;
    private  int Pagenum;
    private int totalRecords;
    private int startindex;
    private int totalPage;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    private int pagesize=3;
    private String url;//每页访问的url路径
    public Page(int Pagenum,int totalRecords){
        this.Pagenum=Pagenum;
        this.totalRecords=totalRecords;
        startindex=(Pagenum-1)*pagesize;
        totalPage=totalRecords%pagesize==0?totalRecords/pagesize:totalRecords/pagesize+1;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPagenum() {
        return Pagenum;
    }

    public void setPagenum(int pagenum) {
        Pagenum = pagenum;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartindex() {
        return startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
