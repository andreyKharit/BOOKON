<%--
  ~ 2020
  ~ Last updated: 4/2/20, 1:03 AM
  ~ Author: Andrey Kharitonenko
  --%>

<html>
<style>
    th, td {
        padding: 10px;
        text-align: left;
    }
</style>
<head>
    <title>Welcome to BOOKON</title>
</head>
<body>
<%@include file="header-bar.jsp" %>

<div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container" style="text-align:center">

        <form action="create_book" method="post">
            <div class="container">
                Book:
                <input type="text" name="book">
                Author:
                <input type="text" name="author">
                Publisher:
                <input type="text" name="publisher">
                <p>Genre: </p>
                <input type = "checkbox" name = "genres" value="Mystery"/> Mystery
                <input type = "checkbox" name = "genres" value="Comedy"/> Comedy
                <input type = "checkbox" name = "genres" value="Romance"/> Romance
                <input type = "checkbox" name = "genres" value="Classic"/> Classic
                <input type = "checkbox" name = "genres" value="Thriller"/> Thriller
                <input type = "checkbox" name = "genres" value="Horror"/> Horror
                <input type = "checkbox" name = "genres" value="Non-Fiction"/> Non-Fiction
                <input type="submit" class="btn btn-primary" value="Create">
            </div>
        </form>



        <h1 class="w3-text-teal">Welcome to BOOKON</h1>
        <p>Submit your credentials to proceed. <a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></p>
        <p>New here? <a href="${pageContext.request.contextPath}/register.jsp">REGISTRATION FORM</a></p>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>