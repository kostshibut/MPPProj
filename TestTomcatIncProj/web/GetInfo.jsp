<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DBConnect" method="post">
    <input type="hidden" value="get_info" name="action">
    Press button to get info from db
    <br>
    <input type="submit">

    <br>
    <a href="index.jsp">Back</a>
</form>
${answer}
</body>
</html>