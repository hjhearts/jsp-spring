<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String imgName = request.getParameter("imgName");
%>
<html>
<head>
    <title>Duke Image</title>
</head>
<body>
    <br/><br/>
    <h1>이름은 <%=name%> 입니다.</h1><br/><br/>
    <img src="image/<%=imgName%>" alt="<%=imgName%>"/>
</body>
</html>
