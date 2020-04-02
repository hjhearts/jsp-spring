<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-18
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int score = Integer.parseInt(request.getParameter("score"));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>점수 : <%=score%></h1>
    <%if(score >= 90){%>
    <h1>A학점</h1>
    <%}else if(score >= 80){%>
        <h1>B학점</h1>
    <%}else if(score >= 70){%>
        <h1>C학점</h1>
    <%}else if(score >= 60){%>
        <h1>D학점</h1>
    <%}else{%>
        <h1>F학점</h1>
    <%}%>
</body>
</html>
