<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/19/20, 12:44 AM
  ~ Author: Andrey Kharitonenko
  --%>
<%--TODO jstl try--%>
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

<%@include file="footer.jsp" %>

</body>