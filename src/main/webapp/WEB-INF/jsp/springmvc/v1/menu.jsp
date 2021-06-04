<%@ page import="kr.mjc.sehyuckpark.web.dao.User" %>
<nav><span style="font-weight: bold;">[Spring MVC v1]</span> <a href="./">홈
</a> <a href="./app/springmvc/v1/user/userList">사용자</a>
    <a href="./app/springmvc/v1/article/articleList">게시글</a>
    <% User sessionUser = (User) session.getAttribute("USER");
        if (sessionUser != null) {  %>
    <a href="./app/springmvc/v1/user/userInfo"><%= sessionUser.getName()%>
    </a>님 <a href="./app/springmvc/v1/user/logout">로그아웃</a>
    <% } else {  %>
    <a href="./app/springmvc/v1/user/loginForm">로그인</a> <a
            href="./app/springmvc/v1/user/joinForm">회원가입</a>
    <%}%>
</nav>