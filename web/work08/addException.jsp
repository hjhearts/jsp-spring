<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
<h2>문제가 발생했습니다. 자세한 내용은 하단을 참조하세요.</h2>
<h3 class="error"><%=exception.toString()%></h3>
<h3 class="error"><%=exception.getMessage()%></h3>
<%exception.printStackTrace();%>
</body>
</html>
