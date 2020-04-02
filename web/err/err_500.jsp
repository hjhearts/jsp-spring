<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <style>
        .error{color:red}
    </style>
    <title>500 Exception</title>
</head>
<body>
<h1>500 EXCEPTION</h1>
<h3 class="error">Some exception has find</h3>
<h3 class="error"><%=exception.getMessage()%></h3>
<%exception.printStackTrace();%>
</body>
</html>
