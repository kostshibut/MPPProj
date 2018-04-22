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

        <c:if test="${teacher != null}">
            Teacher spetialization: ${teacher.spetialization} <br>
            Teacher name: ${teacher.userByUserUserId.firstName} <br>
            ${teacher.userByUserUserId.lastName} <br>
            Teacher email ${teacher.userByUserUserId.email} <br>
            Teacher age: ${teacher.userByUserUserId.age} <br>
            Teacher education: ${teacher.userByUserUserId.education} <br>
            <c:if test="${loggedScholar != null}">
                <a href="/createFeedback/${teacher.teacherId}/${loggedScholar.scholarId}">Create feedback on teacher</a>
            </c:if>

            <h1>Отзывы на учителя </h1>
            <c:forEach items="${teacherFeedback}" var="feedback">
                =================================================================== <br>
                By ${feedback.scholarByScholarScholarId.userByUserUserId.firstName}
                ${feedback.scholarByScholarScholarId.userByUserUserId.lastName} <br>
                Mark: ${feedback.mark} <br>
                Description ${feedback.description} <br>
                =================================================================== <br>
            </c:forEach>
        </c:if>
        <a href="/teacherList">back to teachers list</a> <br>
        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
