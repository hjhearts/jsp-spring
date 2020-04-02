<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="javax.servlet.RequestDispatcher"%>
<%
    request.setAttribute("name", "한주성");
    request.setAttribute("address", "경기도 하남시");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    RequestDispatcher dis = request.getRequestDispatcher("/work07/request2.jsp");
    dis.forward(request, response);
%>
</body>
</html>
