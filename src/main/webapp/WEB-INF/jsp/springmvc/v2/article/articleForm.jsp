<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
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
<h3>글쓰기</h3>
<form action="./springmvc/v2/article/addArticle" method="post">
    <p><input type="text" name="title" placeholder="제목" required autofocus/></p>
    <p><textarea name="content" placeholder="내용" required></textarea></p>
    <p>
        <button type="submit">저장</button>
        <button type="button" onclick="history.back();">취소</button>
    </p>
</form>
</body>
</html>