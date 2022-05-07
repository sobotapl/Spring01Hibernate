<%--
  Created by IntelliJ IDEA.
  User: sobota
  Date: 24/04/2022
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="/bookForm/delete" modelAttribute="book">
    <form:hidden path="id" value="${book.id}"></form:hidden>
    <input type="submit" value="usuń">
</form:form>
<a href="/bookForm/all">anuluj</a>
</body>
</html>