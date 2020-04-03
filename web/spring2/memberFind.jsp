<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-04-03
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="${pageContext.request.contextPath}/mem2.do">
        <input type="text" name="value"/>
        <select name="action">
            <option value="listMembers" selected>전체</option>
            <option value="selectMemberById">아이디</option>
            <option value="selectMemberByPwd">패스워드</option>
        </select><br/>
        <input type="submit" value="검색"/>
    </form>
</body>
</html>
