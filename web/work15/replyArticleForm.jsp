<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-27
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<%int parentNO = Integer.parseInt(request.getParameter("articleNO"));%>
<html>
<head>
    <title>Title</title>
    <style>
        table td{
            border: 1px solid black;
        }
        table td input{

        }
    </style>
</head>
<body>
<script>
    function readURL(input){
        if(input.files && input.files[0]){
            var reader = new FileReader();
            reader.onload = function(e){
                $('#preview').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
    function backToList(form){
        form.action = '${pageContext.request.contextPath}/board/listArticles.do';
        form.submit();
    }
</script>
<form name="articleForm" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/board/replyArticle.do">
    <table style="border:1px solid black">
        <tr>
            <th colspan="2">글쓰기 게시판</th>
        </tr>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" size="40%"/></td>
        </tr>
        <tr>
            <td>파일 첨부</td>
            <td><input type="file" name="imageFileName" onchange="readURL(this)"/></td>
        </tr>
        <tr>
            <td>글쓰기</td>
            <td><textarea cols="40" rows="30" id="content" name="content"></textarea></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="업로드"/>
                <input type="reset" value="재작성"/>
                <input type="button" onclick="backToList(this.form)" value="뒤로가기"/>
            </td>
        </tr>
        <tr>
            <td>미리보기</td>
            <td><img id="preview" src="#" width="200" height="200" alt="등록 이미지가 없습니다."/></td>
        </tr>
    </table>
    <input type="hidden" name="parentNO" value="<%=parentNO%>"/>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</body>
</html>
