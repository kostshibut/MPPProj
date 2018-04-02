<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <a href="${contextPath}/signUp">Sign Up</a> <br>
        <a href="${contextPath}/signIn">Sign In</a> <br>
    </body>
</html>
