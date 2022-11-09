<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-08
  Time: 오전 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>boardPaging.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<style>
  #list{
    width: 750px;
    margin-top: 50px;
  }
</style>
</body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container" id="list">
  <table class="table table-striped table-hover text-center">
    <tr>
      <th>번호</th>
      <th>제목</th>
<%--      <th>내용</th>--%>
      <th>작성자</th>
      <th>날짜</th>
      <th>조회수</th>
      <%--         <th>삭제</th>--%>
      <%--         <th>수정</th>--%>
    </tr>
    <c:forEach items="${boardList}" var="board">
      <tr>
        <td>${board.id}</td>
        <td>
          <a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a>
        </td>
<%--        <td>${board.boardTitle}</td>--%>
        <td>${board.boardWriter}</td>
<%--        <td>${board.boardCreatedDate}</td>--%>

       <td><c:set var="now" value="<%=new java.util.Date()%>" /><fmt:formatDate var="sysYear" value="${now}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
       <c:out value="${sysYear}" /></td>
        <td>${board.boardHits}</td>

      </tr>
    </c:forEach>
  </table>
</div>
<div class="container">
  <ui class="pagination justify-content-center">
    <c:choose>
      <c:when test="${paging.page<=1}">
        <li class="page-item disabled">
          <a class="page-link">[이전]</a>
        </li>
      </c:when>

    <c:otherwise>
      <li class="page-item">
        <a class="page-link" href="/board/paging?page=${paging.page-1}">[이전]</a>
      </li>
    </c:otherwise>
    </c:choose>

    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
      <c:choose>
        <c:when test="${i eq paging.page}">
          <li class="page-item active">
            <a class="page-link">${i}</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item">
            <a class="page-link" href="/board/paging?page=${i}">${i}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>
    <c:choose>
      <c:when test="${paging.page>=paging.maxPage}">
        <li class="page-item disabled">
          <a class="page-link">[다음]</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item">
          <a class="page-link" herf="/board/paging?page=${paging.page+1}">[다음]</a>
        </li>
      </c:otherwise>
    </c:choose>
  </ui>
</div>
</body>
</html>
