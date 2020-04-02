<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="myweb2.*, java.sql.*" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="myweb2.MemberBean" scope="page"/>
<jsp:setProperty name="bean" property="*"/>
<%
    //MemberBean bean = new MemberBean(id, password, name, email);
    MemberDAO memberDAO = new MemberDAO();
    memberDAO.add(bean);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>아이디</td>
        <td>패스워드</td>
        <td>이름</td>
        <td>이메일</td>
        <td>가입일</td>
    </tr>
    <tr>
        <td><jsp:getProperty name="bean" property="id"/></td>
        <td><jsp:getProperty name="bean" property="pwd"/></td>
        <td><jsp:getProperty name="bean" property="name"/></td>
        <td><jsp:getProperty name="bean" property="email"/></td>
        <td><jsp:getProperty name="bean" property="joinDate"/></td>
    </tr>
</table>
</body>
</html>
