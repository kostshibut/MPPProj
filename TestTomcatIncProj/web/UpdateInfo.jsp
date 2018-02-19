<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DBConnect" method="post">
    <input type="hidden" value="update_info" name="updating">
    Enter user's id : <input name="userIDToUpdate"> <br>
    Enter user's name : <input name="userNameToUpdate"> <br>
    Enter user's age : <input name="userAgeToUpdate"> <br>
    <input type="submit"> <br>
    ${reaction}
    <br>
    <a href="index.jsp">Back</a>
</form>
</body>
</html>
