<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" import="myweb2.*" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="b1" class="myweb2.MemberBean" scope="page"/>
<jsp:setProperty name="b1" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<%
    MemberBean b2 = new MemberBean("son", "1234", "손흥민", "son@korea.co.kr");
    memberList.add(b1);
    memberList.add(b2);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>${memberList[i].id}</td>
        <td>${memberList[i].pwd}</td>
        <td>${memberList[i].name}</td>
        <td>${memberList[i].email}</td>
    </tr>
</table>
</body>
</html>
