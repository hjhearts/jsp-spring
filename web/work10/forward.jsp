<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    request.setAttribute("address", "서울시 강남구");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="member2"/>
</body>
</html>
