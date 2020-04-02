<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-19
  Time: 오후 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        import="java.util.*"
        import="myweb2.*"
%>
<%
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    MemberDAO dao = new MemberDAO();
    List<MemberBean> list = dao.findMember(name);
%>
<html>
<head>
    <title>Title</title>
    <style>table{text-align: center;width: 70%}</style>
</head>
<body>
<%if(list.size() > 0){%>
    <table border="1" align="center">
        <tr><td colspan="5">결과</td></tr>
        <tr>
            <td>아이디</td>
            <td>패스워드</td>
            <td>이름</td>
            <td>이메일</td>
            <td>가입날짜</td>
        </tr>
        <%
            for (int i = 0; i < list.size(); i++) {
                MemberBean dto = list.get(i);
        %>
        <tr>
            <td><%=dto.getId()%></td>
            <td><%=dto.getPwd()%></td>
            <td><%=dto.getName()%></td>
            <td><%=dto.getEmail()%></td>
            <td><%=dto.getJoinDate()%></td>
        </tr>
        <%}%>
    </table>
<%}else{%>
<h2>조회 결과가 없습니다.</h2>
<%}%>
</body>
</html>
