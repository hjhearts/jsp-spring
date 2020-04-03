<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-30
  Time: 오후 5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>아이디 : </td>
            <td>${member.id}</td>
        </tr>
        <tr>
            <td>비밀번호 : </td>
            <td>${member.pwd}</td>
        </tr>
        <tr>
            <td>이름 : </td>
            <td>${member.name}</td>
        </tr>
        <tr>
            <td>이메일 : </td>
            <td>${member.email}</td>
        </tr>
    </table>
</body>
</html>
