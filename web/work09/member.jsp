<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="myweb2.*, java.util.*" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    MemberBean bean = new MemberBean(id, password, name, email);
    MemberDAO memberDAO = new MemberDAO();
    memberDAO.add(bean);
    List memberList = memberDAO.listMembers();
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
        <%
            if(memberList.size() > 0){
                for (int i = 0; i < memberList.size(); i++) {
                    MemberBean curBean = (MemberBean) memberList.get(i);
        %>
        <tr>
            <td><%=curBean.getId()%></td>
            <td><%=curBean.getPwd()%></td>
            <td><%=curBean.getName()%></td>
            <td><%=curBean.getEmail()%></td>
            <td><%=curBean.getJoinDate()%></td>
        </tr>
        <%
                }
            }else{
        %>
        <tr><td colspan="5">등록된 계정이 없습니다.</td></tr>
        <%}%>
    </table>
</body>
</html>
