<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-18
  Time: 오후 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = Integer.parseInt(request.getParameter("number"));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>결과</h2>
    <table>
        <thead>
            <th>식</th>
            <th>결과</th>
        </thead>
        <%
            for (int i = 2; i < 10; i++) {
        %>
        <tr>
            <td><%=num%> X <%=i%></td>
            <td><%=num*i%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
