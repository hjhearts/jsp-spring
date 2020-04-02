<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>MemberForm</title>
</head>
<body>
<form method="post" action="member5.jsp">
    <h2 style="text-align: center">회원 가입</h2>
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
        <tr>
            <td><input type="submit" value="회원 가입"/></td>
            <td><input type="reset" value="재작성"/></td>
        </tr>
    </table>
</form>
</body>
</html>

