<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/bookForm/edit" modelAttribute="book">
    Title: <form:input path="title" value="${b.title}"/></br>
    Rating:<form:input path="rating" value="${b.raiting}"/></br>
    Description:<form:input path="description" value="${b.description}"/></br>
    <form:hidden path="id" value="${b.id}"/>

    Publishers:
    <form:select path="publisher.id" itemValue="id" itemLabel="name" items="${publishers}"/></br>

    <input type="submit">



</form:form>

</body>
</html>
