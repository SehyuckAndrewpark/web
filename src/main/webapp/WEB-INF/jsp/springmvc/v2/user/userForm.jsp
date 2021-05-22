<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getContextPath()%>/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>사용자 등록</h3>
<form action="./springmvc/v2/user/addUser" method="post">
    <p><input type="email" name="email" placeholder="이메일" required autofocus/></p>
    <p><input type="password" name="password" placeholder="비밀번호" required/></p>
    <p><input type="text" name="name" placeholder="이름" required/></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getAttribute("msg"))
        .orElse("")%>
</p>
</body>
</html>