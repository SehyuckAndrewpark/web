<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav><a href="v2">홈</a> <a
        href="./springmvc/user/userList">사용자</a>
    <a href="./springmvc/article/articleList">게시글</a>
    <c:choose>
        <c:when test="${!empty sessionScope.USER}">
            <a href="./springmvc/user/userInfo">${sessionScope.USER.name}</a>님
            <a href="./springmvc/user/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="./springmvc/user/loginForm">로그인</a>
            <a href="./springmvc/user/userForm">회원가입</a>
        </c:otherwise>
    </c:choose>
</nav>