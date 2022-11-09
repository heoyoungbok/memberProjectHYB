<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>memberList.jsp</title>
  <script src="/resources/js/jquery.js"></script>
</head>
<body>
        <tr>
            <th>번호</th>
            <th>이메일</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>나이</th>
            <th>전화번호</th>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>${member.memberEmail}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberMobile}</td>

            </tr>
        </c:forEach>
</body>
</html>
