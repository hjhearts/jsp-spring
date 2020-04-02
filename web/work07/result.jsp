<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-18
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user_id = request.getParameter("user_id");
    String user_pwd = request.getParameter("user_pwd");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>RESULT</h1>
<%
    if(user_id == null || user_id.length() == 0){
%>
<br>아이디를 입력하세요
<%
    }else{
%>
<h1>아이디 : <%=user_id%></h1>
<h1>패스워드 : <%=user_pwd%></h1>
<%
    }
%>
</body>
</html>
