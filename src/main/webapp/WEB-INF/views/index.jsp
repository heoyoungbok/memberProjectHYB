<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<button onclick="saveFn()">회원가입</button>
<button onclick="loginFn()">로그인</button>
<%--<button onclick="boardListFn()">글목록</button>--%>
</body>
<script>
    const saveFn = () => {
      location.href="/save";
    }
    const loginFn = () => {
      location.href="/login";
    }
    // const boardListFn = () => {
    //   location.href="/boardList";
    // }

</script>
</html>
