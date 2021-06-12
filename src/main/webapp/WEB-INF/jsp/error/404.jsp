<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="./css/article.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/header.jsp" %>
<main>
    <h3>에러 페이지</h3>
    <ul class="info">
        <li><p class="warn">404 Not Found</p></li>
        <li><p class="warn">URI
            : ${requestScope['javax.servlet.error.request_uri']}</p></li>
    </ul>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
</bodY>
</html>
