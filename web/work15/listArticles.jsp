<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-03-25
  Time: 오후 4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%request.setCharacterEncoding("utf-8");%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="articlesList" value="${articleMap.articleList}"/>
<c:set var="totArticle" value="${articleMap.totalArticles}"/>
<c:set var="section" value="${articleMap.section}"/>
<c:set var="pageNum" value="${articleMap.pageNum}"/>
<html>
<head>
    <title>Title</title>
    <style>
        .sel-page{text-decoration: none; color:red}
        .no-uline{text-decoration: none}
    </style>
</head>
<body>
    <table>
        <tr>
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        <c:choose>
            <c:when test="${articlesList == null}">
                <tr>
                    <td colspan="4">게시물이 없습니다.</td>
                </tr>
            </c:when>
            <c:when test="${articlesList != null}">
                <c:forEach var="article" items="${articleMap.articleList}" varStatus="articleNum">
                    <tr>
                        <td>${articleNum.count}</td>
                        <td>${article.id}</td>
                        <td>
                            <c:choose>
                                <c:when test="${article.level > 1}">
                                    <c:forEach begin="1" end="${article.level}" step="1">
                                        <span style="padding-left: 20px"></span>
                                    </c:forEach>
                                    <span>[답변]</span>
                                    <a href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">
                                        ${article.title}
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">
                                        ${article.title}
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            ${article.writeDate}
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
    </table>
    <div class="text_center">
        <c:if test="${totArticle != null}">
            <c:choose>
                <c:when test="${totArticle > 100}">
                    <c:forEach var="page" begin="1" end="10" step="1">
                        <c:if test="${section > 1 && page == 1}">
                            <a class="no-uline"
                               href="${contextPath}/board/listArticles.do?section=${section-1}&pageNum=${(section-1)*10+1}">
                                PRE
                            </a>
                        </c:if>
                        <a class="no-uline" href="${contextPath}/board/listArticles.do?section=${section}&pageNum=${page}">
                            ${(section-1)*10+page}
                        </a>
                        <c:if test="${page == 10}">
                            <a class="no-uline"
                               href="${contextPath}/board/listArticles.do?section=${section+1}&pageNum=${section*10+1}">
                                NEXT
                            </a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <c:when test="${totArticle == 100}">
                    <c:forEach var="page" begin="1" end="10" step="1">
                        <a class="no-uline" href="#">${page}</a>
                    </c:forEach>
                </c:when>
                <c:when test="${totArticle < 100}">
                    <c:forEach var="page" begin="1" end="${totArticle/10 + 1}" step="1">
                        <c:choose>
                            <c:when test="${page==pageNum}">
                                <a class="sel-page"
                                   href="${contextPath}/board/listArticles.do?section=${section}&pageNum=${page}">
                                    ${page}
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a class="no-uline"
                                   href="${contextPath}/board/listArticles.do?section=${section}&pageNum=${page}">
                                        ${page}
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:if>
    </div>
    <a href="${contextPath}/board/articleForm.do">글쓰기</a>
    <input type="button" onclick="makeTest()" value="테스트페이지 생성"/>
    <script>
        function makeTest(){
            var conf = confirm('테스트 페이지를 추가하시겠습니까?');
            if(conf){
                location.href = '/board/makeTestArticles.do';
            }
        }
    </script>
</body>
</html>
