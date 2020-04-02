<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-18
  Time: 오후 5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align: center;
        }
        ul{
            list-style:none;
        }
        li{
            border-bottom: 2px solid black;
        }
        img{
            width: 100px;
            height: 100px;
            margin:10px;
        }
    </style>
</head>
<body>
    <ul>
        <li>
            <span>이미지</span>
            <span>이미지 이름</span>
            <span>선택하기</span>
        </li>
        <%
            for(int i=0; i<10; i++){
        %>
        <li>
            <a href="#"><img src="image/duke.png" alt="duke"/></a>
            <a href="#"><strong>듀크<%=i%></strong></a>
            <a href="#"><input type="checkbox" name="chk<%=i%>"/></a>
        </li>
        <%
            }
        %>
    </ul>
</body>
</html>
