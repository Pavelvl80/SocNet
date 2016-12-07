<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<br>
<!--this is bad way to call userName, too complex, just add userName to model attributes -->
${userName} <br>
<br>
<c:forEach items="${messages}" var="message">
    To user: ${message.toUser.userName} <br> From user: ${message.fromUser.userName} <br> text: ${message.msg} <br> data sent ${message.dateSent}, data read ${message.dateRead} <br>
    <br>
</c:forEach>

</body>
</html>