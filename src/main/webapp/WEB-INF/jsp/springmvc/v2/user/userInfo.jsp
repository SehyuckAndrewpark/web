<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>사용자 정보</h3>
<p>사용자 번호 : ${user.userId}</p>
<p>이메일 : ${user.email}</p>
<p>이름 : ${user.name}</p>
<p><a href="./app/springmvc/v2/article/userArticles?userId=${user.userId}">
    ${user.name}의 글</a></p>
</body>
</html>