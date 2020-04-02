<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-18
  Time: 오후 3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String name = "James";
    public String getName(){
        return name;
    }
    /*
    JAVA주석문입니다.
     */
%>
<%
    int age = Integer.parseInt(request.getParameter("age"));
%>
<%-- JSP주석문입니다. --%>
<html>
<head>
    <title>Title</title>
    <!-- HTML주석문입니다. -->
</head>
<body>
<h1>Hello my name is <%=name%></h1>
<h1>My age is <%=age%></h1>
</body>
</html>
