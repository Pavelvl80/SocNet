<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<br>
${messages.get(0).getFromUser().getUserName()}'s messages: <br>
<br>
<c:forEach items="${messages}" var="message">
    To user: ${message.toUser.userName} <br> text: ${message.msg} <br> data sent ${message.dateSent}, data read ${message.dateRead} <br>
    <br>
</c:forEach>

</body>
</html>