<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${result}" var="result">
    <h1>${result.getPropertyPath()} : ${result.getMessage()}</h1><br>
</c:forEach>

</body>
</html>
