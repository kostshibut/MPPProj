<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 06.04.2018
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="${contextPath}/logout">logout</a> <br>

        <c:if test="${loggedAdmin != null}">
            Asuh admin ${loggedAdmin.userByUserUserId.login} <br>
            <a href="/userControll">ControllUser</a>
        </c:if>

        <c:if test="${loggedTeacher != null}">
            Asuh teacher ${loggedTeacher.userByUserUserId.login} <br>
        </c:if>

        <c:if test="${loggedScholar != null}">
            Asuh scholar ${loggedScholar.userByUserUserId.login} <br>
        </c:if>

        <c:if test="${loggedAdmin == null and loggedTeacher == null and loggedScholar == null or param.logout eq true}">
            <a href="${contextPath}/signUp">Sign Up</a> <br>
            <a href="${contextPath}/signIn">Sign In</a> <br>
        </c:if>

        <br>

        <h1>Предметы, на которые подписан ученик</h1>
        <c:forEach items="${subbedSubject}" var="subject">
            ========================================================== <br>
            Subject name: ${subject.name} <br>
            Subject duration:  ${subject.duration} <br>
            Teacher spetialization: <br>
            ${subject.teacherByTeacherTeacherId.spetialization}
            Teacher name: ${subject.teacherByTeacherTeacherId.userByUserUserId.firstName}
            ${subject.teacherByTeacherTeacherId.userByUserUserId.lastName} <br>
            <a href="/readmoreTeacher/${subject.teacherByTeacherTeacherId.teacherId}">Read More about teacher</a> <br>
            <a href="/readmoreSubject/${subject.subjectId}">Read More about subject</a> <br>
            <c:if test="${loggedScholar != null}">
                <label>You already subbed</label> <br>
            </c:if>
            ========================================================== <br>
        </c:forEach>

        <a href="${contextPath}/start">back to start page</a> <br>
        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
