<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-25
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<script src="http://localhost:8080/work14/js/invalidate.js"></script>
<body>
    <form name="addForm" method="post" action="${contextPath}/member/addMember.do" >
        <table>
            <tr>
                <td><label>아이디</label></td>
                <td><input type="text" name="id" id="id"/></td>
            </tr>
            <tr>
                <td><label>패스워드</label></td>
                <td><input type="password" name="pwd" id="pwd"/></td>
            </tr>
            <tr>
                <td><label>패스워드확인</label></td>
                <td><input type="password" name="re_pwd"/></td>
            </tr>
            <tr>
                <td><label>이름</label></td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td><label>이메일</label></td>
                <td><input type="email" name="email"/></td>
            </tr>
        </table>
        <input type="button" onclick="checkInvalidate()" value="회원가입"/>
        <input type="reset" value="다시 작성하기"/>
    </form>
</body>
</html>
