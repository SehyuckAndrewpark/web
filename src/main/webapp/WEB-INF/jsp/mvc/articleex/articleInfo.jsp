<%@ page import="kr.mjc.sehyuckpark.web.dao.Article" %>
<!DOCTYPE html>
<% Article article = (Article) session.getAttribute("Article"); %>
<html>
<body>
<h1>글 정보</h1>
<p><%= article %>
</p>
<nav><a href="./articleList">목록으로 돌아가기</a></nav>
</body>
</html>