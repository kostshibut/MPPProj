<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DBConnect" method="post">
    <input type="hidden" value="del_info" name="deleting">
    Enter user's id to delete : <input name="userIDDelete"> <br>
    <input type="submit"> <br>
    ${reaction}
    <br>
    <a href="index.jsp">Back</a>
</form>
</body>
</html>
