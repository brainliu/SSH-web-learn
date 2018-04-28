<%--
  Created by IntelliJ IDEA.
  User: gczx
  Date: 2018/4/26
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/manage/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="${pageContext.request.contextPath}/servlet/ControllerServlet?op=addCategory" method="post">
    <table border="1" align="center">
        <tr>
            <td>(*)分类名称:</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>分类描述：</td>
            <td>
                <textarea rows="3" cols="38" name="description"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
