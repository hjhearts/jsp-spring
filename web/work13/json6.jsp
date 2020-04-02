<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-24
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="jquery-1.11.0.min.js"></script>
<script>
    $(function(){
        $('#checkJson').on('click', function(e){
            $.ajax({
                async:false,
                type:'post',
                url:'${pageContext.request.contextPath}/json2',
                success:function(data, status){
                    var jsonInfo = JSON.parse(data);
                    var memberInfo = "회원정보 <br/>";
                    memberInfo += '=================<br/>';
                    for(var i in jsonInfo.member){
                        memberInfo += jsonInfo.member[i].name + "<br/>";
                        memberInfo += jsonInfo.member[i].age + "<br/>";
                        memberInfo += jsonInfo.member[i].gender + "<br/>";
                        memberInfo += jsonInfo.member[i].nickname + "<br/><br/><br/>";
                    }
                    $('#output').html(memberInfo);
                },
                error:function(d, s){
                    alert('error');
                },
                complete:function(d,t){
                }
            });
        })
    });
</script>
<button id="checkJson">회원정보 수신</button>
<div id="output"></div>
</body>
</html>

