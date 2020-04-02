<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:redirect url="member1.jsp">
        <c:param name="id" value="kim"/>
        <c:param name="pwd" value="1234"/>
        <c:param name="name" value="김유신"/>
        <c:param name="email" value="kim@test.com"/>
    </c:redirect>
</body>
</html>
