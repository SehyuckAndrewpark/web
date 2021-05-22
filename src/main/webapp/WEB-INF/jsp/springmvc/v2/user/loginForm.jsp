<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getContextPath()%>/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>로그인</h3>
<form action="./springmvc/v2/user/login" method="post">
    <p><input type="email" name="email" placeholder="이메일" required autofocus/></p>
    <p><input type="password" name="password" placeholder="비밀번호" required/></p>
    <p>
        <button type="submit">로그인</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getAttribute("msg"))
        .orElse("")%>
</p>
</body>
</html>