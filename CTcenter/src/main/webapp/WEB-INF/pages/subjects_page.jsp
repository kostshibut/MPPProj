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
        <c:if test="${loggedAdmin != null}">
            Asuh admin ${loggedAdmin.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
        </c:if>

        <c:if test="${loggedTeacher != null}">
            Asuh teacher ${loggedTeacher.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
        </c:if>

        <c:if test="${loggedScholar != null}">
            Asuh scholar ${loggedScholar.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
        </c:if>

        <c:if test="${loggedAdmin == null and loggedTeacher == null and loggedScholar == null or param.logout eq true}">
            <a href="${contextPath}/signUp">Sign Up</a> <br>
            <a href="${contextPath}/signIn">Sign In</a> <br>
        </c:if>

        <c:if test="${loggedScholar != null}">
            UnSubbed <br> ========================================================= <br>
        </c:if>
        <c:forEach items="${listOfUnsubbedSubjects}" var="subject">
            <c:if test="${listOfUnsubbedSubjects.size() != 0}">
            ------------------------------------------------------------------------------------- <br>
            <form method="post" action="/enroll/${subject.subjectId}">
                Subject name: ${subject.name} <br>
                Subject duration:  ${subject.duration} <br>
                Teacher spetialization: <br>
                        ${subject.teacherByTeacherTeacherId.spetialization}
                Teacher name: ${subject.teacherByTeacherTeacherId.userByUserUserId.firstName} <br>
                ${subject.teacherByTeacherTeacherId.userByUserUserId.lastName} <br>
                    <a href="/readmoreSubject/${subject.subjectId}">Read More about subject</a> <br>
                    <c:if test="${loggedScholar != null}">
                        <button type="submit">Enroll</button>
                    </c:if> <br>
            </form>
            ------------------------------------------------------------------------------------- <br>
            </c:if>
        </c:forEach>
        <a href="${contextPath}/start">back to start page</a> <br>
    </body>
</html>
