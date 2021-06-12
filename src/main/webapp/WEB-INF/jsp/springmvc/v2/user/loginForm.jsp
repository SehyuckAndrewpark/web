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
    <h3>로그인</h3>
    <form action="./app/springmvc/v2/user/login" method="post">
        <p><input type="email" name="email" value="${email}" placeholder="이메일"
                  required autofocus/></p>
        <p><input type="password" name="password" placeholder="비밀번호" required/></p>
        <p>
            <button type="submit" class="button a">로그인</button>
        </p>
        <input type="hidden" name="returnUrl"
                            value="${!empty param.returnUrl? param.returnUrl : header.referer}"/>
    </form>
    <p style="color:red;">${msg}</p>
</main>
<%@include file="/WEB-INF/jsp/springmvc/v2/footer.jsp"%>
</body>
</html>