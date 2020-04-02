<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-30
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8");%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${contextPath}/test/memberInfo.do">
        <table>
            <tr>
                <td><label>아이디</label></td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td><label>패스워드</label></td>
                <td><input type="password" name="pwd"/></td>
            </tr>
            <tr>
                <td><label>이름</label></td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td><label>이메일</label></td>
                <td><input type="email" name="email"/></td>
            </tr>
        </table>
        <input type="submit" value="회원정보확인"/>
    </form>
</body>
</html>
