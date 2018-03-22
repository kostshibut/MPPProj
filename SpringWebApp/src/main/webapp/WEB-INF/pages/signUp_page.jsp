<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--@elvariable id="userJSP" type="com.Dimcooo"--%>
        <spring:form method="post" modelAttribute="userJSP" action="/signUp">
            Name: <spring:input path="username"/>
            Age: <spring:input path="password"/>
            <spring:button>Sign Up</spring:button>
        </spring:form>

        <a href="${contextPath}/start">back</a>
    </body>
</html>
