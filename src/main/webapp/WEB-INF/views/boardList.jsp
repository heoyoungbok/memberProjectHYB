<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오후 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardList.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="container" id="list">
    <table class="table table-striped table-hover text-center">
     <tr>
         <th>번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>날짜</th>
         <th>조회수</th>
<%--         <th>삭제</th>--%>
<%--         <th>수정</th>--%>
     </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>${board.boardId}</td>
                <td>${board.boardTitle}</td>
                <td>${board.boardWriter}</td>
                <td>${board.boardCreatedDate}</td>
                <td>${board.boardHits}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
