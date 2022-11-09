<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteCheck.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<form action="/board/delete" method="post" name="updateForm">
    <input type="text" name="id" value="${board.id}"readonly>
    <input type="text" name="boardWriter" value="${sessionScope.loginEmail}" readonly>
    <input type="text" name="boardTitle" value="${board.boardTitle}">
    <textarea name="boardContents" cols="30" rows="10">${board.boardContents}</textarea>
    <input type="button" value="삭제" onclick="deleteCheck()">
</form>

</body>
    <script>   // 권한부여
        const deleteCheck = () => {
            const writer = '${sessionScope.loginEmail}';
            const email = '${board.boardWriter}';


            if(email != writer){
                document.updateForm.submit();
            }else {
                alert ("비정상적인 접근입니다.");
            }
        }
    </script>
</html>
