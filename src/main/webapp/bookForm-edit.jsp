<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="POST" action="/bookForm/edit" modelAttribute="book">
    <form:hidden path="id" value="${book.id}"></form:hidden>

    Title: <form:input path="title" value="${book.title}"/> </br>
    <form:errors path="title"/></br>

    Rating: <form:input path="rating" value="${book.rating}"/> </br>
    <form:errors path="rating"/></br>

    Description: <form:input path="description" value="${book.description}"/> </br>
    <form:errors path="description"/></br>

    Pages: <form:input path="pages" value="${book.pages}"/> </br>
    <form:errors path="description"/></br>

    Publishers:
    <form:select path="publisher.id" itemValue="id"
                 itemLabel="name" items="${publishers}"/> </br>
    <input type="submit">
</form:form>

</body>
</html>
