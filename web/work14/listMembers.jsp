<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-25
  Time: 오전 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:choose>
        <c:when test="${msg == 'add'}">
            <script>
                window.onload = function(){
                    alert('새 회원을 추가했습니다.');
                }
            </script>
        </c:when>
        <c:when test="${msg == 'modify'}">
            <script>
                window.onload = function(){
                    alert('회원정보를 수정했습니다.');
                }
            </script>
        </c:when>
        <c:when test="${msg == 'delete'}">
            <script>
                window.onload = function(){
                    alert('회원을 제거했습니다.');
                }
            </script>
        </c:when>
    </c:choose>
    <table>
        <tr>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>가입일자</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <c:choose>
            <c:when test="${memberList == null}">
                <tr>
                    <td colspan="5">등록된 회원이 없습니다.</td>
                </tr>
            </c:when>
            <c:when test="${memberList != null}">
                <c:forEach var="mem" items="${memberList}">
                    <tr>
                        <td><c:out value="${mem.id}"/></td>
                        <td><c:out value="${mem.pwd}"/></td>
                        <td><c:out value="${mem.name}"/></td>
                        <td><c:out value="${mem.email}"/></td>
                        <td><c:out value="${mem.joinDate}"/></td>
                        <td><a href="${pageContext.request.contextPath}/member/modMemberForm.do?id=${mem.id}">수정</a></td>
                        <td><a href="${pageContext.request.contextPath}/member/delMember.do?id=${mem.id}">삭제</a></td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
    <a href="${pageContext.request.contextPath}/member/memberForm.do">
        <p>회원가입 하기</p>
    </a>
</body>
</html>
