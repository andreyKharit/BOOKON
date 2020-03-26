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
<table>
    <c:forEach items="${subjects}" var="subject">
        <tr>
            <td><c:out value="${subject.name}"/></td>
            <td><c:out value="${subject.description}"/></td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp" %>

</body>