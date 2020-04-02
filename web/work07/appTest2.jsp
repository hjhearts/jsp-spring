<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String)session.getAttribute("name");
    String address = (String)application.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>이름 : <%=name%></p>
    <p>주소 : <%=address%></p>
</body>
</html>
