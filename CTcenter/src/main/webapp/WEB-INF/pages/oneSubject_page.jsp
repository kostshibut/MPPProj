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
        <br>
        <c:if test="${subject != null}">
            Subject name: ${subject.name} <br>
            Subject duration: ${subject.duration} <br>
            Teacher spetialization: ${subject.teacherByTeacherTeacherId.spetialization} <br>
            Teacher name: ${subject.teacherByTeacherTeacherId.userByUserUserId.firstName} <br>
            ${subject.teacherByTeacherTeacherId.userByUserUserId.lastName} <br>
            Teacher email: ${subject.teacherByTeacherTeacherId.userByUserUserId.email} <br>
        </c:if>

        <c:if test="${loggedScholar != null or loggedTeacher != null or loggedAdmin != null}">
            <c:forEach items="${lessonForSubject}" var="lesson">
                <form method="post">
                    ============================================= <br>
                    Lesson theme: ${lesson.theme} <br>
                    Lesson duration: ${lesson.duration} <br>
                    Subject name: ${lesson.subjectBySubjectSubjectId.name} <br>
                    ============================================= <br>
                    <a href="/task/${lesson.lessonId}">Check tasks</a>
                </form>
            </c:forEach>
        </c:if>

        <a href="/subjectList">back to subject list</a>
    </body>
</html>
