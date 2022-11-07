<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boardSave.jsp</title>
    <script src="/resources/js/jquery.js"></script>
</head>
<body>
<form action="/board/save" method="post" name="boardForm"enctype="multipart/form-data">
    <input type="text" name="boardWriter" value="${sessionScope.loginEmail}" placeholder="작성자" readonly>
    <input type="text" name="boardTitle" placeholder="제목">
    <textarea name="boardContents" placeholder="내용을 입력하세요" cols="30" rows="10"></textarea>
        <input type="file" name="boardFile">
        <input type="submit" value="글쓰기">
</form>
</body>
</html>