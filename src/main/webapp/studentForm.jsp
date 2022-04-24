<%--
  Created by IntelliJ IDEA.
  User: sobota
  Date: 24/04/2022
  Time: 11:25
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

<form:form method="post" action="student" modelAttribute="student">
    Name: <form:input path="firstName"/></br>
    Surname: <form:input path="lastName"/></br>
    Male: <form:radiobutton path="gender" value="M"/></br>
    Female: <form:radiobutton path="gender" value="F"/></br>
    Country: <form:select path="country" items="${countries}"/></br>
    Notes: <form:textarea path="notes" rows="3" cols="20"/></br>
    MailingList: <form:checkbox path="mailingList"/></br>
    ProgrammingSkills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/></br>
    Hobbies: <form:checkboxes items="${hobbies}" path="hobbies"/></br>
    <input type="submit">

</form:form>

</body>
</html>
