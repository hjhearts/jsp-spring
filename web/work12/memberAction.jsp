<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, myweb2.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bean" class="myweb2.MemberBean"/>
<jsp:setProperty name="bean" property="*"/>
<%
    System.out.println(request.getParameter("name"));
    System.out.println(bean.getName());
    MemberDAO dao = new MemberDAO();
    dao.add(bean);
    List memberList = dao.listMembers();
    request.setAttribute("memberList", memberList);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:forward page="memberList.jsp"/>
</body>
</html>
