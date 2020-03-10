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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%@include file="footer.jsp" %> 

<ul>
<%--    <li><a href="/profile">Profile</a></li>--%>
<%--    <li><a href="/browse-bookons">Browse BOOKONS</a></li>--%>
    <li><a href="<c:url value="/subjects"/>">Browse Users</a></li>
    <li><a href="<c:url value="/logout"/>">Sign Out</a></li>
</ul>
<hr/>

<%@include file="footer.jsp" %>

</body>
</html>