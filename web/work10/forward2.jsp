<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="myweb2.*" %>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<%
    request.setCharacterEncoding("UTF-8");
    MemberBean member1 = new MemberBean("son", "1234", "손흥민", "son@totham.com");
    MemberBean member2 = new MemberBean("park", "4321", "박지성", "park@manchester.com");
    memberList.add(member1);
    memberList.add(member2);
    request.setAttribute("memberList", memberList);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="member2.jsp"/>
</body>
</html>
