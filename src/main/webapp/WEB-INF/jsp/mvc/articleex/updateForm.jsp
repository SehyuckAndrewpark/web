<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h1>글 수정하기</h1>
<form action="updateArticle" method="post">
    <p><input type="text" name="articleId" placeholder="글 번호" required autofocus/></p>
    <p><input type="title" name="title" placeholder="수정할 제목" required autofocus/></p>
    <p><input type="content" name="content" placeholder="수정할 내용" required autofocus/></p>
    <p><input type="userId" name="userId" placeholder="유저 번호" required autofocus/></p>
    <p>
        <button type="submit">수정 완료</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>