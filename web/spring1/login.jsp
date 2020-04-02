<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-30
  Time: 오후 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="frmLogin" method="post" action="${contextPath}/test/login.do">
        <table>
            <tr>
                <td><label>아이디</label></td>
                <td><input type="text" name="userID" size="20"/></td>
            </tr>
            <tr>
                <td><label>패스워드</label></td>
                <td><input type="password" name="password" size="20"/></td>
            </tr>
        </table>
        <input type="submit" value="로그인"/>
    </form>
</body>
</html>
