<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <th>아이디</th>
            <th>패스워드</th>
            <th>이름</th>
            <th>이메일</th>
        </thead>
        <tr>
            <td><c:out value="${param.id}" default="cha"/></td>
            <td><c:out value="${param.pwd}" default="7777"/></td>
            <td><c:out value="${param.name}" default="차범근"/></td>
            <td><c:out value="${param.email}" default="legend@korea.kr"/></td>
        </tr>
    </table>
</body>
</html>
