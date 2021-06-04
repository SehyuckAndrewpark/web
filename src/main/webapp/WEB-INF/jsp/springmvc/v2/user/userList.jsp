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
<h3>사용자 목록</h3>
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
<c:forEach var="user" items="${userList}">
    <p style="margin:0">${user.userId}, ${user.email}, ${user.name}</p>
</c:forEach>
<script>
    var form1 = document.forms["form1"];
    document.getElementById("btnPrev").onclick = function () {
        form1["page"].value--;
    };

    document.getElementById("btnNext").onclick = function () {
        form1["page"].value++;
    };

    form1["count"].onchange = function () {
        form1.submit();
    }
</script>
</body>
</html>