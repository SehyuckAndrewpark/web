<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <a href="./"><img src="./images/spring-logo.svg" class="logo"/></a>
</header>
<ul class="nav">
    <li>
        <a href="./app/springmvc/v2/user/userList">사용자</a>
    </li>
    <li><a href="./app/springmvc/v2/article/articleList">게시글</a></li>
    <c:choose>
        <c:when test="${!empty sessionScope.USER}">
            <li><a
                    href="./app/springmvc/v2/user/s/myInfo">${sessionScope.USER.name}님</a>
            </li>
            <li><a href="./app/springmvc/v2/user/s/logout">로그아웃</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="./app/springmvc/v2/user/loginForm">로그인</a></li>
            <li><a href="./app/springmvc/v2/user/joinForm">회원가입</a></li>
        </c:otherwise>
    </c:choose>
</ul>