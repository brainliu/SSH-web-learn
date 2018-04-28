package com.itcast.web.Controller;

import com.itcast.DBCPUtil.WebUtil;
import com.itcast.domain.Book;
import com.itcast.domain.Category;
import com.itcast.service.BussinessService;
import com.itcast.service.impl.BusinessServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public class ControllerServlet extends HttpServlet{
    private BussinessService s=new BusinessServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("addCategory".equals(op)) {
            addCategory(request, response);
        } else if ("Listcategory".equals(op)) {
            listCategoies(request, response);
        }else if("addBookUI".equals(op)){
            addBookUI(request,response);
        }else if("addBook".equals(op)){
            addBook(request,response);
        }
    }

    private void addBookUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> cs=s.finAllCategories();
        request.setAttribute("cs",cs);
        request.getRequestDispatcher("/manage/addBook.jsp").forward(request,response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart)
            throw new RuntimeException("你的表单enctype属性必须是multipart/form-data类型的");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        try {
            List<FileItem> items = sfu.parseRequest(request);
            Book book = new Book();
            for(FileItem item:items){
                if(item.isFormField()){
                    ProcessFormField(item,book);
                }else{
                    processUPload(item,book);
                }
            }
            s.addBook(book);
            response.getWriter().write("<script type='text/javascript'>alert('添加成功')</script>");
            response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/servlet/ControllerServlet?op=addBookUI");
        } catch (FileUploadException e) {
            throw new RuntimeException("解析上传请求失败");
        }
    }

    private void ProcessFormField(FileItem item, Book book) {
        try {
            String fieldName = item.getFieldName();//表单字段名和javabean中的属性一致
            String fieldValue = item.getString("UTF-8");
            BeanUtils.setProperty(book, fieldName, fieldValue);
        } catch (Exception e) {
            throw new RuntimeException("封装JavaBean失败");
        }


    }

    private void processUPload(FileItem item, Book book) {
        if(item.getContentType().startsWith("image")){
            String oleImagename="";
            String filename=item.getFieldName();
            if(filename.indexOf("\\")>-1){
                oleImagename=filename.substring(filename.lastIndexOf("\\")+1);
            }else{
                oleImagename=filename;
            }
            book.setOldImageName(oleImagename);
            String extendfilename=filename.substring(filename.lastIndexOf("."+1));
            String newImagename= UUID.randomUUID().toString()+"."+extendfilename;
            
            book.setNewImageName(newImagename);
            String storedDirectory=getServletContext().getRealPath("/images");
            String  newpath=makenewpath(storedDirectory,newImagename);
            book.setPath(newpath);
        }
    }

    private String makenewpath(String storedDirectory, String newImagename) {
        int hashcode=newImagename.hashCode();
        int dir1=hashcode&0xf;
        int dir2=(hashcode&0xf)>>4;

        String Path=dir1+"/"+dir2;
        File file=new File(storedDirectory+"/"+Path);
        if(!file.exists()){
            file.mkdirs();
        }
        return Path;
    }

    private void listCategoies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Category> cs=s.finAllCategories();
        request.setAttribute("cs",cs);
//        String pagenum=request.getParameter("pagenum");
//        String categorId=request.getParameter("categoryId");
//        Page  page=s.finPageBook(pagenum,categorId);

        request.getRequestDispatcher("/manage/Listcategory.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Category category = WebUtil.fillbean(request,Category.class);
        s.addCategory(category);
        response.getWriter().write("<script type='text/javascript'>alert('添加成功')</script>");
        response.setHeader("Refresh", "0;URL="+request.getContextPath()+"/manage/addCategory.jsp");
    }
}
