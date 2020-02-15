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
    <li><a href="${pageContext.request.contextPath}/subjects">Browse Users</a></li>
    <li><a href="/logout">Sign Out</a></li>
</ul>
<hr/>

<%@include file="footer.jsp" %>

</body>
</html>