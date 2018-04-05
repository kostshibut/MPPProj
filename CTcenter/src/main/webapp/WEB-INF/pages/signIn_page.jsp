<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <spring:form method="post" modelAttribute="loginUser" action="/signIn">
            Login: <spring:input path="login"/>
            Password: <spring:input path="pass"/>
            <spring:button>SignIn</spring:button>
        </spring:form>

        ${user.password}
        <a href="${contextPath}/signUp">Create an account</a> <br>
        <a href="${contextPath}/start">back</a> <br>
    </body>
</html>
