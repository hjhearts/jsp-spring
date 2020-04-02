<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4><c:out value="&lt" escapeXml="true"/></h4>
<h4><c:out value="&lt" escapeXml="false"/></h4>
<h4><c:out value="&gt" escapeXml="true"/></h4>
<h4><c:out value="&gt" escapeXml="false"/></h4>
<h4><c:out value="&amp" escapeXml="true"/></h4>
<h4><c:out value="&amp" escapeXml="false"/></h4>
<h4><c:out value="&#039" escapeXml="true"/></h4>
<h4><c:out value="&#039" escapeXml="false"/></h4>
<h4><c:out value="&#034" escapeXml="true"/></h4>
<h4><c:out value="&#034" escapeXml="false"/></h4>
</body>
</html>
