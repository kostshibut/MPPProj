<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 20.04.2018
  Time: 15:14
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
            First Name: ${loggedUser.firstName} <br> <br>
        </c:if>

        <c:if test="${teacher != null}">
            ${teacher.spetialization} <br>
            ${teacher.userByUserUserId.firstName} <br>
            ${teacher.userByUserUserId.lastName} <br>
            ${teacher.userByUserUserId.email} <br>
            ${teacher.userByUserUserId.age} <br>
            ${teacher.userByUserUserId.education} <br>
        </c:if>
    <a href="/teacherList">back to teachers list</a>
    </body>
</html>
