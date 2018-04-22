<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 22.04.2018
  Time: 18:35
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

        <c:forEach items="${taskForSubject}" var="task">
            ============================================================================= <br>
            Subject: ${task.lessonByLessonLessonId.subjectBySubjectSubjectId.name} <br>
            Teacher name: ${task.lessonByLessonLessonId.subjectBySubjectSubjectId.teacherByTeacherTeacherId.userByUserUserId.firstName}
            ${task.lessonByLessonLessonId.subjectBySubjectSubjectId.teacherByTeacherTeacherId.userByUserUserId.lastName} <br>
            Teacher spetialization: ${task.lessonByLessonLessonId.subjectBySubjectSubjectId.teacherByTeacherTeacherId.spetialization} <br>
            Lesson theme: ${task.lessonByLessonLessonId.theme} <br>
            Task theme: ${task.theme} <br>
            Content: ${task.content} <br>
            ============================================================================= <br>
        </c:forEach>

        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
