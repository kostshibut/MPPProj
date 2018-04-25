<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 22.04.2018
  Time: 21:30
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
            <a href="/userControll">ControllUser</a>
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
            Feedback on teacher: ${teacher.userByUserUserId.firstName}
            ${teacher.userByUserUserId.lastName} <br>
            Spetialization: ${teacher.spetialization}
            <spring:form method="post" modelAttribute="feedbackOnTeacher" action="/createFeedback/${teacher.teacherId}/${loggedScholar.scholarId}">
                Mark: <spring:input path="mark"/>
                Description <spring:input path="description"/>
                <spring:button>Send feedback</spring:button>
            </spring:form>

            <c:if test="${error != null}">
                ${error.name} <br>
                ${error.description} <br>
            </c:if>
        </c:if>

        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
