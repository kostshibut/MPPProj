<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DBConnect" method="post">
    <input type="hidden" value="get_info" name="getting">
    Press button to get info from db
    <br>
    <input type="submit">

    <br>
    <a href="index.jsp">Back</a>
</form>
${answer}
</body>
</html>