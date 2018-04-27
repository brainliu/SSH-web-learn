package com.itcast.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class setALLcharacterEncodingFilter implements Filter{
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request= (HttpServletRequest) servletRequest;
            response=(HttpServletResponse) servletResponse;
        }
        catch (Exception e)
        {
            throw  new RuntimeException("non-http request");
        }


        String encoding="utf-8";
        String  value=filterConfig.getInitParameter("encoding");
       if (value!=null)
           encoding=value;
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        
        MyhttpServletRequest mrequest=new MyhttpServletRequest(request);
        filterChain.doFilter(mrequest,response);
    }
    

    @Override
    public void destroy() {

    }


}
class MyhttpServletRequest  extends HttpServletRequestWrapper{
    private  HttpServletRequest request;

    public MyhttpServletRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    public String getParameter(String name){
        String value=request.getParameter(name);
        if(value==null)
            return null;
        String method=request.getMethod();
        if("get".equalsIgnoreCase(method)){
            try {
                value=new String(value.getBytes("ISO-8859-1"),request.getCharacterEncoding());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}

