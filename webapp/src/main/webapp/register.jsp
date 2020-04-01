<%--
  ~ 2020
  ~ Last updated: 4/2/20, 1:03 AM
  ~ Author: Andrey Kharitonenko
  --%>

<%--
  Created by IntelliJ IDEA.
  User: poppy
  Date: 3/25/2020
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BOOKON|New User</title>
</head>
<body>
<%@include file="header-bar.jsp" %>

<div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container" style="text-align:center">
        <h1 class="w3-text-teal">CREATE NEW ACCOUNT</h1>
        <p>
        <form action="registration" method="post">
            <input type="text" name="username">
            <input type="password" name="password">
            <input type="submit" value="Register">
        </form>
        </p>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>