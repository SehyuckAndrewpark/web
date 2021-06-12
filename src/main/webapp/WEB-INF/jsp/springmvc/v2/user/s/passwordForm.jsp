<!DOCTYPE html>
<html>
<head>
    <title>사용자</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="./css/article.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/headerNav.jsp" %>
<main>
    <h3>비밀번호 수정</h3>
    <form name="form1" action="./app/springmvc/v2/user/s/updatePassword"
          method="post">
        <p><input type="password" name="password" placeholder="현재 비밀번호" required
                  autofocus/>
        </p>
        <p><input type="password" name="newPassword" placeholder="새 비밀번호"
                  required/></p>
        <p>
        <p><input type="password" name="newPasswordConfirm" placeholder="새 비밀번호 확인"
                  required/></p>
        <p>
            <button type="submit" class="button a">저장</button>
            <button type="button" onclick="history.back();" class="button b">취소
            </button>
        </p>
    </form>
    <p class="warn">${msg}</p>
</main>
<%@ include file="/WEB-INF/jsp/springmvc/v2/footer.jsp" %>
<script>
    var form1 = document.form1;
    form1.onsubmit = function () {
        if (form1.newPassword.value != form1.newPasswordConfirm.value) {
            alert("새 비밀번호가 서로 다릅니다.");
            form1.newPassword.value = "";
            form1.newPasswordConfirm.value = "";
            form1.newPassword.focus();
            return false;
        }
    }
</script>
</body>
</html>