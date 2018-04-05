<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%--@elvariable id="loginUser" type="com.Dimcooo"--%>
        <spring:form method="post" modelAttribute="loginUser" action="/signIn">
            Login: <spring:input path="login"/>
            Password: <spring:input path="pass"/>
            <spring:button>SignIn</spring:button>

            <c:if test="${param.success eq true}">
                <div class="alert alert-success">Sign In successfull</div>
            </c:if>

            <c:if test="${param.success eq false}">
                <div class="alert alert-success">Error</div>
            </c:if>

            <c:if test="${param.user != null}">
                <div class="alert alert-success">${param.user.age}</div>
            </c:if>
        </spring:form>
        <a href="${contextPath}/signUp">Create an account</a> <br>
        <a href="${contextPath}/start">back</a> <br>
    </body>
</html>
