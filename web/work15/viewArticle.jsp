<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-26
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<c:set var="article" value="${article}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <style>
        .label{
            background-color:lightgray;
        }
        table{
            width:600px;
            border:1px solid black;
        }
        table td{
            border: 1px solid black;
        }
        :disabled{
            background-color: #FFFFFF;
        }
        .title{
            font-weight: bold;
            font-size:20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <form name="form" method="post">
    <table>
        <tr>
            <td class="label">글제목</td>
            <td><input class="title" type="text" id="title" name="title" value="${article.title}" disabled/></td>
        </tr>
        <tr>
            <td class="label">글내용</td>
            <td><textarea rows="20" cols="60" name="content" id="content" disabled>${article.content}</textarea></td>
        </tr>
        <c:if test="${not empty article.imageFileName}">
            <tr>
                <td class="label">이미지</td>
                <td><img
                     src="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNO=${article.articleNO}"/>
                </td>
            </tr>
            <tr>
                <td class="label">다운로드</td>
                <td><a href="${contextPath}/download.do?imageFileName=${article.imageFileName}&articleNO=${article.articleNO}">
                    ${article.imageFileName}
                </a></td>
            </tr>
        </c:if>
            <tr>
                <td colspan="2">
                    <input id="modBtn" type="button" value="수정하기" onclick="toModify()"/>
                    <input type="button" value="삭제하기" onclick="toDelete()"/>
                    <input type="button" value="답글달기"
                           onclick="location.href = '/board/replyArticleForm.do?articleNO=${article.articleNO}'"/>
                </td>
            </tr>
    </table>
        <input type="hidden" name="articleNO" value="${article.articleNO}"/>
    </form>
    <script>
        function toModify(){
            var title = document.getElementById("title");
            var content = document.getElementById("content");
            title.disabled = false;
            content.disabled = false;
            var btn = document.getElementById("modBtn");
            btn.value = '수정반영하기';
            btn.onclick = function(){
                var form = document.form;
                form.action = '/board/modArticle.do';
                form.submit();
            }
        }
        function toDelete(){
            var delMsg = confirm('정말로 삭제하시겠습니까?');
            if(delMsg){
                var form = document.form;
                form.action = '/board/delArticle.do';
                form.submit();
            }
        }
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</body>
</html>
