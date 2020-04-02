<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="title1" value="hello world!"/>
    <c:set var="title2" value="JSP와 Spring페이지 입니다."/>
    <c:set var="str1" value="와"/>
    title1 = "hello world!"<br/>
    title2 = "JSP와 Spring페이지 입니다."<br/>
    str1 = "와"<br/>
    fn:length(title1) : ${fn:length(title1)}<br/>
    fn:toUpperCase(title1) : ${fn:toUpperCase(title1)}<br/>
    fn:toLowerCase(title2) : ${fn:toLowerCase(title1)}<br/><br/>
    fn:substring(title1, 3, 6) : ${fn:substring(title1, 3, 6)}<br/>
    fn:trim(title1) : ${fn:trim(title1)}<br/>
    fn:replace(title1, " ", "/") : ${fn:replace(title1, " ", "/")}<br/><br/>
    fn:indexOf(title2, str1) : ${fn:indexOf(title2, str1)}<br/>
    fn:contains(title1, str1) : ${fn:contains(title1, str1)}<br/>
    fn:contains(title2, str1) : ${fn:contains(title2, str1)}
</body>
</html>
