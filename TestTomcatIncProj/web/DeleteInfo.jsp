<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form action="DBConnect" method="post">
            <input type="hidden" value="del_info" name="deleting">
            Enter user's id to delete : <input name="userIDDelete" required pattern="[1-9]{1}$|^[1-9]{1}[0-9]{1}$|^100" title="только от 1 до 100"> <br>
            <input type="submit"> <br>
            ${reaction}
            <br>
            <a href="index.jsp">Back</a>
        </form>
    </body>
</html>
