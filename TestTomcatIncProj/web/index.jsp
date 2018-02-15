<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="DBConnect" method="post">
            <!--<input name="setInfo">-->
            <input type="hidden" value="get_info" name="action">
            Press button <br>
            <input type="submit">
        </form>
    ${answer}
    </body>
</html>
