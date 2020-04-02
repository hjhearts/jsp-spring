<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String)session.getAttribute("name");
    session.setAttribute("address", "서울시 종로구");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>세션 결과입니다.</h3>
    <h4><%=name%></h4>
    <a href="session2.jsp">다움 페이지로</a>
</body>
</html>
