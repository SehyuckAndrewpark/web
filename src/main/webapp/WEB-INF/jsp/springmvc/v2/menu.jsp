<%@ page import="kr.mjc.sehyuckpark.web.dao.User" %>
<nav><span style="font-weight: bold;">[Spring MVC v2]</span> <a href="./">홈
</a> <a href="./springmvc/v2/user/userList">사용자</a>
    <a href="./springmvc/v2/article/articleList">게시글</a>
    <% User sessionUser = (User) session.getAttribute("USER");
        if (sessionUser != null) {  %>
    <a href="./springmvc/v2/user/userInfo"><%= sessionUser.getName()%>
    </a>님 <a href="./springmvc/v2/user/logout">로그아웃</a>
    <% } else {  %>
    <a href="./springmvc/v2/user/loginForm">로그인</a> <a
            href="./springmvc/v2/user/userForm">회원가입</a>
    <%}%>
</nav>