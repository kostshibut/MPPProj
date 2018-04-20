<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 19.04.2018
  Time: 17:19
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

        <c:forEach items="${listOfSubjects}" var="subject">
            <form method="post" action="/enroll/${subject.subjectId}">
                ${subject.name} <br>
                ${subject.duration} <br> <br>
                Teacher:
                Spetialization:
                        ${subject.teacherByTeacherTeacherId.spetialization} <br>
                ${subject.teacherByTeacherTeacherId.userByUserUserId.firstName} <br>
                ${subject.teacherByTeacherTeacherId.userByUserUserId.lastName} <br>
                ${subject.teacherByTeacherTeacherId.userByUserUserId.email} <br>
                <button type="submit">Enroll</button>
            </form>
        </c:forEach>

        <a href="${contextPath}/start">back</a> <br>
    </body>
</html>
