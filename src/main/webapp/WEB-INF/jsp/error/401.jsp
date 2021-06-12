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
        <li><p class="warn">401 Unauthorized</p></li>
        <li><p class="warn">권한이 없습니다.</p></li>
    </ul>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
</bodY>
</html>