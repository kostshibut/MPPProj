<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sign in</title>
    </head>
    <style>
        <%@include file="../_css/bootstrap.min.css"%>
        <%@include file="../_css/signin.css"%>
        <%@include file="../js/bootstrap.min.js"%>
    </style>
    <body class="text-center">
        <form class="form-signin">
            <img class="mb-4" width="72" height="72"  src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" >
            <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
            <spring:form method="post" modelAttribute="loginUser" action="/signIn">
                Login: <spring:input path="login" cssClass="form-control" /> <br>
                Password: <spring:input path="pass" cssClass="form-control"/>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <spring:button>SignIn</spring:button>
                <br>
            </spring:form>
        </form>
        <div class="rightside">
            <a href="${contextPath}/signUp" class="form-control">Create an account</a>
            <br>
            <a href="${contextPath}/start" class="form-control">back to start page</a>
        </div>
        <c:if test="${error != null}">
            ${error.name} <br>
            ${error.description} <br>
        </c:if>
        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

      <!--  <a href="${contextPath}/signUp">Create an account</a> <br> -->
       <!-- <a href="${contextPath}/start">back to start page</a> <br> -->
        <!--<button type="button" name="back" onclick="history.back()">back</button>-->
    </body>
</html>