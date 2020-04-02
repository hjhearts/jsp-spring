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
            var _jsonInfo = '{"name":"손흥민", "age":26, "gender":"남자", "nickname":"sonic"}';
            $.ajax({
                async:false,
                type:'post',
                url:'${pageContext.request.contextPath}/jsons',
                data:{jsonInfo:_jsonInfo},
                success:function(data, status){
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
<button id="checkJson">확인</button>
<div id="output"></div>
</body>
</html>
