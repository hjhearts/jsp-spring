<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String)request.getAttribute("name");
    String address = (String)request.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println("<p>이름 : " + name + "</p>");
%>
    <p>이름 : <%=name%></p>
    <p>주소 : <%=address%></p>
</body>
</html>
