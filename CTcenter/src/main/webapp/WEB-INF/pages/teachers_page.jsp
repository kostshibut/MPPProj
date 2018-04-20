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
        <c:if test="${loggedUser != null}">
            Last Name: ${loggedUser.lastName} <br>
            First Name: ${loggedUser.firstName} <br>
        </c:if> <br> <br>

        <c:forEach items="${listOfTeachers}" var="teacher">
            ${teacher.spetialization} <br>
            ${teacher.userByUserUserId.firstName} <br>
            ${teacher.userByUserUserId.lastName} <br>
            <a href="/readmoreTeacher/${teacher.teacherId}">Read More about teacher</a> <br>
        </c:forEach>

        <a href="${contextPath}/start">back to start page</a> <br>
    </body>
</html>
