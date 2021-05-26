<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>게시글 보기</h3>
<p><a
        href="./springmvc/v2/article/articleList?page=${sessionScope.currentPage}&count=${sessionScope.countPerPage}">목록</a>
    <a
            href="./springmvc/v2/article/myArticle?page=${sessionScope.currentPage}&count=${sessionScope.countPerPage}">내 글 목록</a>
    <a
            href="./springmvc/v2/article/articleEdit?articleId=${article.articleId}">수정</a>
    <a id="btnDel"
       href="./springmvc/v2/article/deleteArticle?articleId=${article.articleId}">삭제</a>
</p>
<hr/>
<p>${article.articleId}. ${article.title}</p>
<p>${article.name} / ${article.udate}</p>
<hr/>
<p>${article.contentHtml}</p>
<hr/>
<script>
    document.getElementById("btnDel").onclick = function () {
        return confirm("삭제하시겠습니까?");
    }
</script>
</body>
</html>