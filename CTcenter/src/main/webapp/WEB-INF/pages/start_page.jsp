<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:if test="${loggedUser != null}">
            Asuh ${loggedUser.firstName} <br>
            <a href="${contextPath}/personalArea">Personal Area</a>
        </c:if>

        <c:if test="${error != null}">
            ${error.name} <br>
            ${error.description} <br>
        </c:if>

        <c:if test="${loggedUser == null}">
            <a href="${contextPath}/signUp">Sign Up</a> <br>
            <a href="${contextPath}/signIn">Sign In</a> <br>
        </c:if>
    </body>
</html>
