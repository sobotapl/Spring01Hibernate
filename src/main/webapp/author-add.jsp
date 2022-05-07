<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="POST" action="/authorAdd" modelAttribute="author">
    Imie: <form:input path="firstName"/> </br>
    <form:errors path="firstName"/></br>

    Nazwisko: <form:input path="lastName"/> </br>
    <form:errors path="lastName"/></br>

    PESEL: <form:input path="pesel"/> </br>
    <form:errors path="pesel"/></br>

    E-mail: <form:input path="email"/> </br>
    <form:errors path="email"/></br>




    <input type="submit">
</form:form>

</body>
</html>
