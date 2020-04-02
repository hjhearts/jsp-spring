<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오전 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false"
         import="myweb2.*, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    MemberBean b1 = new MemberBean("son", "1234", "손흥민", "son@korea.kr");
    MemberBean b2 = new MemberBean("park", "4321", "박지성", "park@korea.kr");
    MemberBean b3 = new MemberBean("hwang", "1111", "황의조", "hwang@korea.kr");
    List<MemberBean> memberList = new ArrayList<>();
    memberList.add(b1);
    memberList.add(b2);
    memberList.add(b3);
%>
<c:set var="memberList" value="<%=memberList%>" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table style="border:1px solid black">
        <thead>
            <th>아이디</th>
            <th>패스워드</th>
            <th>이름</th>
            <th>이메일</th>
        </thead>
        <c:forEach items="${memberList}" var="data" >
            <tr>
                <td>${data.id}</td>
                <td>${data.pwd}</td>
                <td>${data.name}</td>
                <td>${data.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
