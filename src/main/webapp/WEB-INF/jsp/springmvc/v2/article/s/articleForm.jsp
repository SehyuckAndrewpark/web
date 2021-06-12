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
    <h3>글쓰기</h3>
    <form action="./app/springmvc/v2/article/s/addArticle" method="post">
        <p><input type="text" name="title" placeholder="제목" required autofocus/></p>
        <p><textarea name="content" placeholder="내용" required></textarea></p>
        <p>
            <button type="submit" class="button a">저장</button>
            <button type="button" onclick="history.back();" class="button b">취소
            </button>
        </p>
    </form>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
</body>
</html>