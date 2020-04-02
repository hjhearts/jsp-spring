<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = (String)session.getAttribute("name");
    String address = (String)session.getAttribute("address");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>세션 결과입니다</h3>
    <h4>이름 : <%=name%>, 주소 : <%=address%></h4>
</body>
</html>
