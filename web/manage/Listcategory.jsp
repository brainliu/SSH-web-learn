<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1" width="438">
    <tr>
        <th>选择</th>
        <th>序号</th>
        <th>分类名称</th>
        <th>分类描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="vs">
        <tr class="${vs.count%2==0?'odd':'even' }">
            <td>
                <input type="checkbox" name="categoryId" value="${c.id}"/>
            </td>
            <td>${vs.count}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>
                <!-- 略 -->
                [<a href="#">修改</a>]
                [<a href="#">删除</a>]
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

