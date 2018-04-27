package com.itcast.web.Controller;

import com.itcast.DBCPUtil.WebUtil;
import com.itcast.domain.Category;
import com.itcast.service.BussinessService;
import com.itcast.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ControllerServlet extends HttpServlet{
    private BussinessService s=new BusinessServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("addCategory".equals(op)) {
            addCategory(request, response);
        } else if ("Listcategory".equals(op)) {
            listCategoies(request, response);
        }
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
