<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/19/20, 12:44 AM
  ~ Author: Andrey Kharitonenko
  --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BOOKON|Login</title>
</head>
<body>
<%@include file="header-bar.jsp" %>

<div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container" style="text-align:center">
        <h1 class="w3-text-teal">LOGIN</h1>
        <c:out value="${sessionScope.currentMessage}"/>
        <p>
        <form action="login" method="post">
            <input type="text" name="username">
            <input type="password" name="password">
            <input type="submit" value="Proceed">
        </form>
        </p>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>