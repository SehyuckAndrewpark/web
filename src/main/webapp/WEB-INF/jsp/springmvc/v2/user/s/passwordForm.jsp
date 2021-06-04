<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>
<%@ include file="/WEB-INF/jsp/springmvc/v2/menu.jsp" %>
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
        <button type="submit">저장</button>
        <button type="button" onclick="history.back();">취소</button>
    </p>
</form>
<p style="color:red;">${msg}</p>
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