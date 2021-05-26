<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav><span style="font-weight: bold;">[Spring MVC v2]</span> <a href="./">홈</a>
    <a href="./springmvc/v2/user/userList">사용자</a>
    <a href="./springmvc/v2/article/articleList">게시글</a>
    <a href="./springmvc/v2/article/myArticle">내 게시글</a>
    <c:choose>
        <c:when test="${!empty sessionScope.USER}">
            <a href="./springmvc/v2/user/myInfo">${sessionScope.USER.name}</a>님
            <a href="./springmvc/v2/user/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="./springmvc/v2/user/loginForm">로그인</a>
            <a href="./springmvc/v2/user/userForm">회원가입</a>
        </c:otherwise>
    </c:choose>
</nav>