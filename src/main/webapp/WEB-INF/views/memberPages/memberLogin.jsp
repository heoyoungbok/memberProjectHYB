<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberLogin.jsp</title>
</head>
<body>
    <form action="/login" method="post">
        <input type="text" name="memberEmail" id="memberEmail" placeholder="이메일">
        <input type="text" name="memberPassword" id="memberPassword" placeholder="비밀번호">
        <input type="submit" value="로그인">
    </form>
</body>
</html>
