<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 20.04.2018
  Time: 14:30
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
        </c:if>

        <c:if test="${subject != null}">
            ${subject.name} <br>
            ${subject.duration} <br>
            ${subject.teacherByTeacherTeacherId.spetialization} <br>
            ${subject.teacherByTeacherTeacherId.userByUserUserId.firstName} <br>
            ${subject.teacherByTeacherTeacherId.userByUserUserId.lastName} <br>
            ${subject.teacherByTeacherTeacherId.userByUserUserId.email} <br>
        </c:if>

    <a href="/subjectList">back to subject list</a>
    </body>
</html>
