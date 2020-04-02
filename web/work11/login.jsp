<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String err = request.getParameter("isErr");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="result.jsp">
        <table>
            <%if(err != null){if(err.equalsIgnoreCase("true")){%>
            <h1>아이디를 입력하세요</h1>
            <%}}%>
            <tr>
                <td><label>아이디</label></td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td><label>패스워드</label></td>
                <td><input type="password" name="pwd"/></td>
            </tr>
        </table>
        <input type="submit" value="로그인"/>
    </form>
</body>
</html>
