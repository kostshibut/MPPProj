<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <%--@elvariable id="userJSP" type="com.Dimcooo"--%>
    <spring:form method="post" modelAttribute="userJSP" action="/authorization/signUp">
        Name: <spring:input path="name"/>
        Age: <spring:input path="age"/>
        <spring:button>Sign Up</spring:button>
    </spring:form>
    </body>
</html>
