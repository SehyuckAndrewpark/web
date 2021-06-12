<!DOCTYPE html>
<html>
<head>
    <title>게시글</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="./css/article.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/headerNav.jsp" %>
<main>
    <h3>게시글 보기</h3>
    <p><a href="${sessionScope.listPage}" class="button a">목록</a>
        <a href="./app/springmvc/v2/article/s/articleEdit?articleId=${article.articleId}"
           class="button a">수정</a>
        <a id="btnDel"
           href="./app/springmvc/v2/article/s/deleteArticle?articleId=${article.articleId}"
           class="button a">삭제</a>
    </p>
    <hr/>
    <p>${article.articleId}. <span class="title">${article.titleHtml}</span></p>
    <p><a
            href="./app/springmvc/v2/user/userInfo?userId=${article.userId}">${article.name}</a>
        / ${article.udate}</p>
    <hr/>
    <p>${article.contentHtml}</p>
    <hr/>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
<script>
    document.getElementById("btnDel").onclick = function () {
        return confirm("삭제하시겠습니까?");
    }
</script>
</body>
</html>