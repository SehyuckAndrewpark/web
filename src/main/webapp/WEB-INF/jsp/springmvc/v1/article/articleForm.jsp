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
<%@ include file="/WEB-INF/jsp/springmvc/v1/menu.jsp" %>
<h3>글쓰기</h3>
<form action="./springmvc/v1/article/addArticle" method="post">
    <p><input type="text" name="title" required autofocus/></p>
    <p><textarea name="content" required></textarea></p>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
</body>
</html>