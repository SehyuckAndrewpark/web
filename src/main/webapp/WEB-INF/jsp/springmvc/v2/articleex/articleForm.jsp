<%@ page import="kr.mjc.sehyuckpark.web.dao.User" %>
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
<%@ include file="/WEB-INF/jsp/springmvc/v2/articleex/menu.jsp" %>
<h3>글쓰기</h3>
<% User user = (User)session.getAttribute("USER"); %>
<form action="./springmvc/v2/articleex/addArticle" method="post">
    <p><input type="text" name="title" required autofocus/></p>
    <p><textarea name="content" required></textarea></p>
    <input type="hidden" name="userId" value="<%=user.getUserId()%>"/>
    <input type="hidden" name="name" value="<%=user.getName()%>"/>
    <p>
        <button type="submit">저장</button>
    </p>
</form>
</body>
</html>
