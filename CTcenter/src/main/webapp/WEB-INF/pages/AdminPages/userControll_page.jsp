<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 23.04.2018
  Time: 1:30
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
        </c:if> <br>

        <c:if test="${loggedAdmin == null and loggedTeacher == null and loggedScholar == null or param.logout eq true}">
            <a href="${contextPath}/signUp">Sign Up</a> <br>
            <a href="${contextPath}/signIn">Sign In</a> <br>
        </c:if>

        <c:if test="${loggedAdmin != null}">
            <h1>Teachers</h1>
            <c:forEach items="${teacherList}" var="teacher">
                ======================================================== <br>
                ${teacher.userByUserUserId.firstName}
                ${teacher.userByUserUserId.lastName}
                ${teacher.spetialization} <br>
                ======================================================== <br>
            </c:forEach>

            <h1>Scholars</h1>
            <c:forEach items="${scholarList}" var="scholar">
                ======================================================== <br>
                ${scholar.userByUserUserId.firstName}
                ${scholar.userByUserUserId.lastName}
                <a href="/deleteScholar/${scholar.scholarId}">delete</a>
                ======================================================== <br>
            </c:forEach>
        </c:if>

        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
