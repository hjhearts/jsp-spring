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
    String id = request.getParameter("userID");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(id.length() == 0){
%>
<jsp:forward page="login.jsp">
    <jsp:param name="msg" value="로그인 되지 않았습니다. 아이디를 입력하세요"/>
</jsp:forward>
<%
    }
%>
<h1>HELLO <%=id%> !!</h1>
</body>
</html>
