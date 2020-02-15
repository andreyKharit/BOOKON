<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Subjects</title>
</head>
<body>
<h1>Subjects</h1>
<c:forEach items="${subjects}" var="subject">
    <li>
    <c:out value="${subject.name}"/></br>
    <c:out value="${subject.description}"/>
    </li>
</c:forEach>
</body>
</html>