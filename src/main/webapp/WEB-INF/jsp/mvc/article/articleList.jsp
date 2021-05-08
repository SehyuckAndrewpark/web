<%@ page import="kr.mjc.sehyuckpark.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<nav><a href="./articleForm">글쓰기</a> <a href="getForm">글 검색하기</a> </nav>
<nav><a href="./updateForm">글 수정하기</a> <a href="./deleteForm">글 삭제하기</a> </nav>
<h3>글 목록</h3>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>