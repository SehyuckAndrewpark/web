<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>개인 정보</h3>
<p>사용자 번호 : ${sessionScope.USER.userId}</p>
<p>이메일 : ${sessionScope.USER.email}</p>
<p>이름 : ${sessionScope.USER.name}</p>
<p><a href="./springmvc/v2/user/userEdit">개인정보 수정</a>
    <a href="./springmvc/v2/user/passwordForm">비밀번호 수정</a></p>
</body>
</html>