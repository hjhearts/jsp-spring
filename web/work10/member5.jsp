<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" import="myweb2.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="b1" class="myweb2.MemberBean" scope="page"/>
<jsp:setProperty name="b1" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<jsp:useBean id="membersMap" class="java.util.HashMap"/>
<%
    membersMap.put("id", "park");
    membersMap.put("pwd", "4321");
    membersMap.put("name", "박지성");
    membersMap.put("email", "jspark@korea.co.kr");
    MemberBean b2 = new MemberBean("son", "1234", "손흥민", "son@korea.co.kr");
    memberList.add(b1);
    memberList.add(b2);
    membersMap.put("memberList", memberList);
%>
<c:set var="memberList" value="${membersMap.memberList}" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>${membersMap.id}</td>
        <td>${membersMap.pwd}</td>
        <td>${membersMap.name}</td>
        <td>${membersMap.email}</td>
    </tr>
    <tr>
        <td>${memberList[0].id}</td>
        <td>${memberList[0].pwd}</td>
        <td>${memberList[0].name}</td>
        <td>${memberList[0].email}</td>
    </tr>
    <tr>
        <td>${memberList[1].id}</td>
        <td>${memberList[1].pwd}</td>
        <td>${memberList[1].name}</td>
        <td>${memberList[1].email}</td>
    </tr>
</table>
</body>
</html>
