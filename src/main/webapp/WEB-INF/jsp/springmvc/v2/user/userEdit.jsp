<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>개인 정보 수정</h3>
<form action="./springmvc/v2/user/updateUser" method="post">
    <p><input type="email" name="email"
              value="${empty user.email? sessionScope.USER.email : user.email}"
              placeholder="이메일" required autofocus/>
    </p>
    <p><input type="name" name="name"
              value="${empty user.name? sessionScope.USER.name : user.name}"
              placeholder="이름" required/></p>
    <p>
        <button type="submit">저장</button>
        <button type="button" onclick="history.back();">취소</button>
    </p>
</form>
<p style="color:red;">${msg}</p>
</body>
</html>