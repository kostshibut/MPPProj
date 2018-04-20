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
            Education
            <spring:select path="education">
                <spring:option value="High">High</spring:option>
                <spring:option value="Middle">Middle</spring:option>
                <spring:option value="Begin">Begin</spring:option>
            </spring:select> <br>
            <spring:button>Sign Up</spring:button>
        </spring:form>

        <c:if test="${error != null}">
            ${error.name} <br>
            ${error.description} <br>
        </c:if>

        <script>
            document.getElementById("login").addEventListener("focusout", function () {
                checkFunc(/^.{1,10}$/, login);
            });

            document.getElementById("password").addEventListener("focusout", function () {
                checkFunc(/^.{10,}$/, password);
            });

            document.getElementById("firstName").addEventListener("focusout", function () {
                checkFunc(/[A-Z][a-zA-Z]*.{1,15}$/, firstName);
            });

            document.getElementById("lastName").addEventListener("focusout", function () {
                checkFunc(/[A-Z][a-zA-Z]*.{1,15}$/, lastName);
            });

            document.getElementById("email").addEventListener("focusout", function () {
                checkFunc(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                    email);
            });

            document.getElementById("age").addEventListener("focusout", function () {
                checkFunc(/^(1(00?|\d)|[2-5]\d|[6-9]\d?)$/, age);
            });

            function checkFunc(regEx, inputName) {
                if(inputName.value.search(regEx) == -1){
                    console.log("it is NOT a normal value");
                }
                else {
                    console.log("it is a normal value");
                }
            }
        </script>

        <a href="${contextPath}/start">back to start page</a>
    </body>
</html>
