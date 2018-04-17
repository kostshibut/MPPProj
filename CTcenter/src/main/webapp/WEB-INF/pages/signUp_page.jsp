<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <spring:form method="post" modelAttribute="userUp" action="/signUp">
            Login: <spring:input path="login"/> <br>
            Password: <spring:input path="password"/> <br>
            First Name: <spring:input path="firstName"/> <br>
            Last Name: <spring:input path="lastName"/> <br>
            Email: <spring:input path="email"/> <br>
            Age: <spring:input path="age"/> <br>
            Education <spring:input path="education"/> <br>
            <spring:button>Sign Up</spring:button>
        </spring:form>

        <a href="${contextPath}/start">back</a>

        <c:if test="${error != null}">
            ${error.name} <br>
            ${error.description} <br>
        </c:if>
    </body>
</html>
