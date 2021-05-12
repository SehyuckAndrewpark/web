<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h1>글 삭제하기</h1>
<form action="deleteArticle" method="post">
    <p><input type="text" name="articleId" placeholder="삭제할 글 번호" required autofocus/></p>
    <p><input type="userId" name="userId" placeholder="유저 번호" required autofocus/></p>
    <p>
        <button type="submit">삭제 완료</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>