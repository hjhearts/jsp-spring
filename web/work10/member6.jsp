<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bean" class="myweb2.MemberBean"/>
<jsp:setProperty name="bean" property="*"/>
<jsp:useBean id="addr" class="myweb2.Address"/>
<jsp:setProperty name="addr" property="city" value="서울"/>
<jsp:setProperty name="addr" property="zipcode" value="07564"/>
<%
    bean.setAddr(addr);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td><%=bean.getId()%></td>
            <td><%=bean.getPwd()%></td>
            <td><%=bean.getName()%></td>
            <td><%=bean.getEmail()%></td>
            <td><%=bean.getAddr().getCity()%></td>
            <td><%=bean.getAddr().getZipcode()%></td>
        </tr>
        <tr>
            <td>${bean.id}</td>
            <td>${bean.pwd}</td>
            <td>${bean.name}</td>
            <td>${bean.email}</td>
            <td>${bean.addr.city}</td>
            <td>${bean.addr.zipcode}</td>
        </tr>
    </table>
</body>
</html>
