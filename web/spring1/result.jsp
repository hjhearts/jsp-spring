<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-30
  Time: 오후 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>아이디</th>
            <th>패스워드</th>
        </tr>
        <tr>
            <td>${userID}</td>
            <td>${password}</td>
        </tr>
    </table>
</body>
</html>
