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
    <h3>개인 정보</h3>
    <ul class="info">
        <li><label>사용자 번호</label> ${sessionScope.USER.userId}</li>
        <li><label>이메일</label> ${sessionScope.USER.email}</li>
        <li><label>이름</label> ${sessionScope.USER.name}</li>
    </ul>
    <p><a href="./app/springmvc/v2/user/s/userEdit" class="button a">개인정보 수정</a>
        <a href="./app/springmvc/v2/user/s/passwordForm" class="button a">비밀번호
            수정</a>
        <a href="./app/springmvc/v2/article/userArticles?userId=${sessionScope.USER.userId}"
           class="button a">내가 쓴 글</a></p>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
</body>
</html>