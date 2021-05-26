<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="count" value="${empty param.count? 20: param.count}"/>
<c:set var="page" value="${empty param.page? 1: param.page}"/>
<c:set var="maxPage" value="${Math.ceil(totalCount / count).intValue()}"/>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
<h3>게시글 목록</h3>
<p>총 ${totalCount}건, ${maxPage}페이지</p>
<form name="form1" method="get">
    <p>
        <button id="btnPrev" type="submit"
                <c:if test="${page <= 1}">disabled</c:if>>이전
        </button>
        <input type="number" name="page" value="${page}" min="1"
               max="${maxPage}" style="width:50px;" readonly/>
        <button id="btnNext" type="submit"
                <c:if test="${page >= maxPage}">disabled</c:if>>다음
        </button>
        <input type="number" name="count" value="${count}" min="10"
               style="width:50px;" step="10"/>행씩
    </p>
</form>
<p><a href="./springmvc/v2/article/articleForm">글쓰기</a></p>
<c:forEach var="article" items="${articleList}">
    <p style="margin: 0;"><a
            href="./springmvc/v2/article/articleView?articleId=${article.articleId}">
            ${article.articleId}. ${article.title}</a> / <a
            href="./springmvc/v2/user/userInfo?userId=${article.userId}">
            ${article.name}</a>, ${article.udate}</p>
</c:forEach>
<script>
    document.getElementById("btnPrev").onclick = function () {
        document.forms["form1"]["page"].value--;
    };

    document.getElementById("btnNext").onclick = function () {
        document.forms["form1"]["page"].value++;
    };

    document.forms["form1"]["count"].onchange = function () {
        document.forms["form1"].submit();
    }
</script>
</body>
</html>