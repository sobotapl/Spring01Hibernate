<%--
  Created by IntelliJ IDEA.
  User: sobota
  Date: 07/05/2022
  Time: 12:40
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

<c:forEach items="${author}" var="a">
    ${a.firstName} - ${a.lastName}, ${a.pesel}, ${b.email}
</c:forEach>

</body>
</html>
