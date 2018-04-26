<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 19.04.2018
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="${contextPath}/start">back to start page</a> <br>
        <c:if test="${loggedAdmin != null}">
             admin ${loggedAdmin.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
            <a href="/userControll">ControllUser</a>
        </c:if>

        <c:if test="${loggedTeacher != null}">
             teacher ${loggedTeacher.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
        </c:if>

        <c:if test="${loggedScholar != null}">
             scholar ${loggedScholar.userByUserUserId.login} <br>
            <a href="${contextPath}/personalArea">Personal Area</a> <br>
        </c:if>

        <c:if test="${loggedAdmin == null and loggedTeacher == null and loggedScholar == null or param.logout eq true}">
            <a href="${contextPath}/signUp">Sign Up</a> <br>
            <a href="${contextPath}/signIn">Sign In</a> <br>
        </c:if>

        <br>

        <c:forEach items="${listOfTeachers}" var="teacher">
            ---------------------------------------------------------- <br>
            Teacher spetialization: ${teacher.spetialization} <br>
            Teacher name ${teacher.userByUserUserId.firstName} <br>
            ${teacher.userByUserUserId.lastName} <br>
            <a href="/readmoreTeacher/${teacher.teacherId}">Read More about teacher</a> <br>
            <c:if test="${loggedScholar != null}">
                <a href="/createFeedback/${teacher.teacherId}/${loggedScholar.scholarId}">Create feedback on teacher</a>
            </c:if> <br>
            ---------------------------------------------------------- <br>
        </c:forEach>

        <button type="button" name="back" onclick="history.back()">back</button>
    </body>
</html>
