<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DBConnect" method="post">
    <input type="hidden" value="set_info" name="setting">
    Enter user's name : <input name="userNameToSet" required pattern="^[A-Za-z]{3,15}$" title="От 3 до 15 букв(без цифр и других символов)"> <br>
    Enter user's age : <input name="userAgeToSet" required pattern="^(1(00?|\d)|[2-5]\d|[6-9]\d?)$" title="От 6 до 100"> <br>
    <input type="submit"> <br>
    ${reaction}
    <br>
    <a href="index.jsp">Back</a>
</form>
</body>
</html>
