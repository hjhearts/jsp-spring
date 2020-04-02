<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-20
  Time: 오후 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<jsp:useBean id="b1" class="myweb2.MemberBean" scope="page"/>
<jsp:setProperty name="b1" property="name" value="한주성"/>
<jsp:useBean id="b2" class="myweb2.MemberBean" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        \${empty b1} : ${empty b1}<br/>
        \${not empty b1} : ${not empty b1}<br/><br/>
        \${empty b2} : ${empty b2}<br/>
        \${not empty b2} : ${not empty b2}<br/><br/>
        \${empty "hello"} : ${empty "hello"}<br/>
        \${empty null} : ${empty null}<br/>
        \${empty ""} : ${empty ""}
    </h2>
</body>
</html>
