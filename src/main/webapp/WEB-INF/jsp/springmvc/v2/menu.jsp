<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav><a href="./"><img src="./images/spring-logo.svg" style="width:100px;"/></a>
    <a href="./app/springmvc/v2/user/userList">사용자</a>
    <a href="./app/springmvc/v2/article/articleList">게시글</a>
    <c:choose>
        <c:when test="${!empty sessionScope.USER}">
            <a href="./app/springmvc/v2/user/s/myInfo">${sessionScope.USER.name}</a>님
            <a href="./app/springmvc/v2/user/s/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="./app/springmvc/v2/user/loginForm">로그인</a>
            <a href="./app/springmvc/v2/user/joinForm">회원가입</a>
        </c:otherwise>
    </c:choose>
</nav>