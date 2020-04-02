<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dan" value="${param.dan}" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <th>연산</th>
            <th>결과</th>
        </thead>
        <c:forEach var="i" begin="2" end="9">
            <tr>
                <td><c:out value="${dan} X ${i}"/></td>
                <td><c:out value="${dan*i}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
