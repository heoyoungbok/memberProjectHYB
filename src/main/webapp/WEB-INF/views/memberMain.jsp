<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberMain.jsp</title>
</head>
<body>
    <button onclick="logout()">로그아웃</button>
    <button onclick="boardSave()">게시글</button>

</body>
<script>
    const logout = () => {
      location.href="/logout"
    }

    const boardSave = () => {
      location.href = "/board/save";
    }
</script>
</html>
