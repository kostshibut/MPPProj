<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yakubovich
  Date: 19.04.2018
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="ctCenter">
    <head>
        <title>Teachers</title>
    </head>
    <style>
        <%@include file="../js/lib/angular.min.js"%>
        <%@include file="../_css/bootstrap.min.css"%>
    </style>
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

        <div ng-controller="TeacherController">
            <table class="table">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Specialization</th>
                </tr>
                <tr ng-repeat="teacher in teachers">
                    <td>{{teacher.firstname}}</td>
                    <td>{{teacher.lastname}}</td>
                    <td>{{teacher.specialization}}</td>
                </tr>
            </table>
        <%--<c:forEach items="${listOfTeachers}" var="teacher">--%>
            <%------------------------------------------------------------ <br>--%>
            <%--Teacher spetialization: ${teacher.spetialization} <br>--%>
            <%--Teacher name ${teacher.userByUserUserId.firstName} <br>--%>
            <%--${teacher.userByUserUserId.lastName} <br>--%>
            <%--<a href="/readmoreTeacher/${teacher.teacherId}">Read More about teacher</a> <br>--%>
            <%--<c:if test="${loggedScholar != null}">--%>
                <%--<a href="/createFeedback/${teacher.teacherId}/${loggedScholar.scholarId}">Create feedback on teacher</a>--%>
            <%--</c:if> <br>--%>
            <%------------------------------------------------------------ <br>--%>
        <%--</c:forEach>--%>

        </div>
        <button type="button" name="back" onclick="history.back()">back</button>
        <script type="text/javascript">
            angular.module('ctCenter', []);
        </script>
    <script src="../js/controllers/TeacherController.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    </body>
</html>
