<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DBConnect" method="post">
    Enter user's name : <input name="userNameToSet"> <br>
    Enter user's age : <input name="userAgeToSet"> <br>
    <input type="submit"> <br>
    ${reaction}
    <br>
    <a href="index.jsp">Back</a>
</form>
</body>
</html>
