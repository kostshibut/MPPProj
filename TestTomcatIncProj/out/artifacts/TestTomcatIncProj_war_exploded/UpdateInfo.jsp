<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="DBConnect" method="post">
            <input type="hidden" value="update_info" name="updating">
            Enter user's id : <input name="userIDToUpdate" required pattern="[1-9]{1}$|^[1-9]{1}[0-9]{1}$|^100" title="только от 1 до 100"> <br>
            Enter user's name : <input name="userNameToUpdate" required pattern="^[A-Za-z]{3,15}$" title="От 3 до 15 букв(без цифр и других символов)"> <br>
            Enter user's age : <input name="userAgeToUpdate" required pattern="^(1(00?|\d)|[2-5]\d|[6-9]\d?)$" title="От 6 до 100"> <br>
            <input type="submit"> <br>
            ${reaction}
            <br>
            <a href="index.jsp">Back</a>
        </form>
    </body>
</html>
