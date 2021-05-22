<%@ page import="kr.mjc.sehyuckpark.web.dao.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%= request.getContextPath()%>/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v1/menu.jsp" %>
<h3>사용자 목록</h3>
<%
    List<User> userList = (List<User>) request.getAttribute("userList");
    for (User user : userList) {%>
<p><%= user.getUserId() %>, <%=user.getEmail()%>, <%= user.getName() %>
</p>
<%
    }
%>
</body>
</html>