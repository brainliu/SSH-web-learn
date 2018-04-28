<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib uri="http://www.itheima.com/jsp/functions" prefix="myfn"%>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>后台管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<br/><br/>
<h1>XX网站后台管理</h1>
<br/>
<a href="${pageContext.request.contextPath}/manage/addCategory.jsp">添加分类</a>
<a href="${pageContext.request.contextPath}/servlet/ControllerServlet?op=Listcategory">查看分类</a>
<a href="${pageContext.request.contextPath}/servlet/ControllerServlet?op=addBookUI">添加书籍</a>
<a href="${pageContext.request.contextPath}/servlet/ControllerServlet?op=listBooks">查看书籍</a>
<a href="">查看订单</a>
<br/><br/>

