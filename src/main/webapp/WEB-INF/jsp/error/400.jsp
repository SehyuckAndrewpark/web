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
        <li><p class="warn">400 Bad Request</p></li>
        <li><p class="warn">요청이 잘못되었습니다.</p></li>
    </ul>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
</bodY>
</html>