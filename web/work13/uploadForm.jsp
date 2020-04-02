<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-23
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/upload.do" method="post" enctype="multipart/form-data">
        파일 1 : <input type="file" name="file1"/><br/>
        파일 2 : <input type="file" name="file2"/><br/>
        매개변수 1 : <input type="text" name="param1"/><br/>
        매개변수 2 : <input type="text" name="param2"/><br/>
        매개변수 3 : <input type="text" name="param3"/><br/>
        <input type="submit" value="업로드"/>
    </form>
</body>
</html>
