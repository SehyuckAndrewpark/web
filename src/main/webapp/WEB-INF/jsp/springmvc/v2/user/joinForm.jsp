<!DOCTYPE html>
<html>
<head>
    <title>사용자</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="./css/article.css">
</head>
<body>
<%@include file="/WEB-INF/jsp/springmvc/v2/header.jsp"%>
<main>
    <h3>사용자 등록</h3>
    <form action="./app/springmvc/v2/user/join" method="post">
        <p><input type="email" name="email" placeholder="이메일" required autofocus/></p>
        <p><input type="password" name="password" placeholder="비밀번호" required/></p>
        <p><input type="text" name="name" placeholder="이름" required/></p>
        <p>
            <button type="submit" class="button a">저장</button>
        </p>
    </form>
    <p class="warn">${msg}</p>
</main>
<%@include file="/WEB-INF/jsp/springmvc/v2/footer.jsp"%>
</body>
</html>