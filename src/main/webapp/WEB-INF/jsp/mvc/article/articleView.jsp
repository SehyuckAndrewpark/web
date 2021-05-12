<%@ page import="kr.mjc.sehyuckpark.web.dao.Article" %>
<% Article article = (Article) request.getAttribute("article");%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getContextPath()%>/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/menu.jsp" %>
<h3>게시글 보기</h3>
<p><a
        href="./mvc/article/articleEdit?articleId=<%=article.getArticleId()%>">수정</a>
    <a
            href="./mvc/article/deleteArticle?articleId=<%=article.getArticleId()%>">삭제</a>
    <a
            href="./mvc/article/articleList?articleId=<%=article.getArticleId()%>">목록</a>
</p>
<hr/>
<p><%= article.getArticleId()%>. <%=article.getTitle()%>
</p>
<p><%= article.getName()%> / <%=article.getUdate()%>
</p>
<hr/>
<p><%= article.getContentHtml()%>
</p>
<hr/>
</body>
</html>
