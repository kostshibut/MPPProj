<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 19.04.2018
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${listOfTeachers}" var="teacher">
        ${teacher.spetialization} <br>
        ${teacher.userByUserUserId.firstName} <br>
        ${teacher.userByUserUserId.lastName} <br> <br>
    </c:forEach>

    <a href="${contextPath}/start">back</a> <br>
</body>
</html>
