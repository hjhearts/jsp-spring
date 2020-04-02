<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    int sum = 0;
    for (int i = 0; i <= num; i++) {
        sum += i;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>1부터 <%=num%>까지의 결과값은 <%=sum%> 입니다.</h4>
</body>
</html>
