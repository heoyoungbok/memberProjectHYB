<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-09
  Time: 오후 5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myPage.jsp</title>
</head>
<body>
    <form class="/myPage" method="post" name="pageForm">
    <input name="memberEmail" id="memberEmail" value="${sessionScope.loginEmail}" placeholder="이메일" readonly>
    <input type="text" name="memberPassword" id="memberPassword" placeholder="비밀번호">
    <input type="text" name="memberName" id="memberName" value="${member.memberName}" placeholder="이름">
    <input type="text" name="memberMobile" id="memberMobile" placeholder="전화번호">
    <input type="file" name="memberProfile" placeholder="프로필사진">
    <input type="button" value="정보수정" onclick="pageUpdateFn()">
</form>
</body>
<script>
    const pageUpdateFn = () => {
      const passUPDB = "${member.memberPassword}";

      if (document.pageForm.memberPassword.value == passUPDB){

          document.pageForm.submit();
      }else {
          alert("비밀번화가 일치하지 않습니다");
      }
    }
</script>
</html>
