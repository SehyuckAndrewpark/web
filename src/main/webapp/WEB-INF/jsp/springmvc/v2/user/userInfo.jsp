<!DOCTYPE html>
<html>
<head>
    <title>사용자</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="./css/article.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/headerNav.jsp" %>
<main>
    <h3>사용자 정보</h3>
    <ul class="info">
        <li><label>사용자 번호</label> <span>${user.userId}</span></li>
        <li><label>이메일</label> <span>${user.email}</span></li>
        <li><label>이름</label> <span>${user.name}</span></li>
    </ul>
    <p><a href="./app/springmvc/v2/article/userArticles?userId=${user.userId}" class="button a">
        ${user.name}의 글</a></p>
</main>
<%@include file="/WEB-INF/jsp/springmvc/v2/footer.jsp"%>
</body>
</html>