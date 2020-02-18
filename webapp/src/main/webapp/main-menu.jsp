<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/19/20, 12:44 AM
  ~ Author: Andrey Kharitonenko
  --%>
<%--TODO ui/bootstrap?/smthW3--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BOOKON|MAIN MENU</title>
</head>
<body>
<h1 style="text-align: center;">BOOKON</h1>
<p style="text-align: center;">Logged in as <%= request.getAttribute("username") %>.</p>
<%! int counter = 0; %>
<% counter += 5; %>
<% counter *= 5; %>
<p style="text-align: center;">Your lucky number is <%= counter %>!</p>
<hr/>
<ul>
    <li><a href="/profile">Profile</a></li>
    <li><a href="/browse-bookons">Browse BOOKONS</a></li>
    <li><a href="<c:url value="/subjects"/>">Browse Users</a></li>
    <li><a href="<c:url value="/logout"/>">Sign Out</a></li>
</ul>
<hr/>

<%@include file="footer.jsp" %>

</body>
</html>