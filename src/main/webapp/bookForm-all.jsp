<%--
  Created by IntelliJ IDEA.
  User: sobota
  Date: 24/04/2022
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${books}" var="b">
    ${b.id} - ${b.title}, ${b.rating}, ${b.description}
    <a href="/bookForm/delete/${b.id}">Usun</a>
    <a href="/bookForm/edit/${b.id}">Edytuj</a> </br>
</c:forEach>

</body>
</html>