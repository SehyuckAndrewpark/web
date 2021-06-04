<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<h3>사용자 등록</h3>
<form action="./app/springmvc/v2/user/join" method="post">
    <p><input type="email" name="email" placeholder="이메일" required autofocus/></p>
    <p><input type="password" name="password" placeholder="비밀번호" required/></p>
    <p><input type="text" name="name" placeholder="이름" required/></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
<p style="color:red;">${msg}</p>
</body>
</html>