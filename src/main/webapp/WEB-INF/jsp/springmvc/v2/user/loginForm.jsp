<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>로그인</h3>
<form action="./springmvc/v2/user/login" method="post">
    <p><input type="email" name="email" value="${email}" placeholder="이메일"
              required autofocus/></p>
    <p><input type="password" name="password" placeholder="비밀번호" required/></p>
    <p>
        <button type="submit">로그인</button>
    </p>
    <p>returnUrl <input type="text" name="returnUrl"
                        value="${!empty param.returnUrl? param.returnUrl : header.referer}"
                        style="width:400px;" readonly/></p>
</form>
<p style="color:red;">${msg}</p>
</body>
</html>