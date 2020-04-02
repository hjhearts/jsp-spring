<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    request.setAttribute("id", "hong");
    request.setAttribute("pwd", "1234");
    session.setAttribute("name", "홍길동");
    application.setAttribute("email", "hong@test.com");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="forward2.jsp"/>
</body>
</html>
