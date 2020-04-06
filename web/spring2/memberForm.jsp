<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-01
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/mem2.do?action=insertMember">
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
                <td><input type="text" name="email"/></td>
            </tr>
        </table>
        <input type="submit" value="회원가입"/>
    </form>
</body>
</html>
