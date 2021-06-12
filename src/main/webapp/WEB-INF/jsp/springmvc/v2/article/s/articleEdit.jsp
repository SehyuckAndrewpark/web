<%@ taglib prefix="e"
           uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
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
    <h3>글수정</h3>
    <form action="./app/springmvc/v2/article/s/updateArticle" method="post">
        <p><input type="text" name="title" value="${e:forHtml(article.title)}"
                  required
                  autofocus/></p>
        <p><textarea name="content"
                     required>${e:forHtml(article.content)}</textarea>
        </p>
        <input type="hidden" name="articleId" value="${article.articleId}"/>
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