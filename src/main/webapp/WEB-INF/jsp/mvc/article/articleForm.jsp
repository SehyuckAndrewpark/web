<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h1>글 등록</h1>
<form action="addArticle" method="post">
    <p><input type="title" name="title" placeholder="제목" required autofocus/></p>
    <p><input type="content" name="content" placeholder="내용" required/></p>
    <h3>로그인</h3>
    <p><input type="userId" name="userId" placeholder="유저 번호" required/></p>
    <p><input type="name" name="name" placeholder="이름" required/></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
<%--<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>--%>
</p>
</body>
</html>