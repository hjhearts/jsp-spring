<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파일 다운로드</title>
</head>
<body>
    <form method="post" action="result.jsp">
        <input type="hidden" name="param1" value="cap1.png"/><br/>
        <input type="hidden" name="param2" value="cap2.png"/><br/>
        <input type="submit" value="이미지 다운로드"/>
    </form>
</body>
</html>
