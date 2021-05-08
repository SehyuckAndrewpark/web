<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h1>글 검색</h1>
<form action="get" method="post">
    <p><input type="text" name="articleId" placeholder="글 번호" required autofocus/></p>
    <p>
        <button type=submit">검색</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg")).orElse("")%>
</p>
</body>
</html>