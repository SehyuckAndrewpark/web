<%@ page import="kr.mjc.sehyuckpark.web.dao.Article" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getContextPath()%>/">
    <style type="text/css">
        input {
            width: 95%;
        }

        textarea {
            width: 95%;
            height: 200px;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>글수정</h3>
<form action="./springmvc/v2/article/updateArticle" method="post">
    <p><input type="text" name="title" value="${article.getTitle()}" required
              autofocus/></p>
    <p><textarea name="content" required>${article.getContent()}</textarea></p>
    <input type="hidden" name="articleId" value="${article.getArticleId()}"/>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
</body>
</html>
