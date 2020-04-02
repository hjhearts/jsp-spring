<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    String msg = request.getParameter("msg");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if(msg != null){%>
    <h1>아이디를 입력하세요</h1>
<%}%>
    <form action="result.jsp" method="post">
        아이디:<input type="text" name="userID"/><br/>
        패스워드:<input type="password" name="userPw"/><br/>
        <input type="submit" value="로그인"/>
    </form>
</body>
</html>
