<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <b>JSP Study Start</b>
    <br/>
    <jsp:include page="duke_image.jsp" flush="true">
        <jsp:param name="name" value="듀크"/>
        <jsp:param name="imgName" value="duke.png"/>
    </jsp:include>
    <br/>
    <b>JSP Study End</b>
</body>
</html>
