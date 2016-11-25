<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<br>
<!--list need to be looper here -->
<c:forEach items="${users}" var="user">
    User ${user.userName}, ${user.email} <br>
</c:forEach>

</body>
</html>