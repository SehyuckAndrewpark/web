<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h3>개인 정보 수정</h3>
    <form action="./app/springmvc/v2/user/s/updateUser" method="post">
        <p><input type="email" name="email"
                  value="${empty user.email? sessionScope.USER.email : user.email}"
                  placeholder="이메일" required autofocus/>
        </p>
        <p><input type="name" name="name"
                  value="${empty user.name? sessionScope.USER.name : user.name}"
                  placeholder="이름" required/></p>
        <p>
            <button type="submit" class="button a">저장</button>
            <button type="button" onclick="history.back();" class="button b">취소
            </button>
        </p>
    </form>
    <p class="warn">${msg}</p>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
</body>
</html>