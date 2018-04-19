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

        <script>
            document.getElementById("login").addEventListener("focusout", function () {
                checkFunc(/^.{0,10}$/, login);
            });

            document.getElementById("password").addEventListener("focusout", function () {
                checkFunc(/^.{10,}$/, password);
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

        <a href="${contextPath}/start">back</a>
    </body>
</html>
