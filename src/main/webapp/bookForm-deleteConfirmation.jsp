<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Remove book</title>
</head>
<body>
<form:form method="POST" action="/bookForm/delete" modelAttribute="book">
  <form:hidden path="id" value="${book.id}"></form:hidden>
  <input type="submit" value="usuń">
</form:form>
<a href="/bookForm/all">anuluj</a>
</body>
</html>
