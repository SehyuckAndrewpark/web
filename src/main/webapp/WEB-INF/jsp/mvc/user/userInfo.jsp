<%@ page import="kr.mjc.sehyuckpark.web.dao.User" %>
<!DOCTYPE html>
<% User user = (User) session.getAttribute("USER"); %>
<html>
<head>
    <base href="<%= request.getContextPath()%>/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/mvc/menu.jsp" %>
<h3>사용자 정보</h3>
<p>사용자 번호 : <%=user.getUserId()%>
</p>
<p>이메일 : <%=user.getEmail()%>
</p>
<p>이름 : <%=user.getName()%>
</p>
</body>
</html>