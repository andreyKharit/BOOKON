<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/19/20, 12:44 AM
  ~ Author: Andrey Kharitonenko
  --%>

<html>
<head>
    <title>Welcome to BOOKON</title>
</head>
<body>
<%@include file="header-bar.jsp" %>

<div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container" style="text-align:center">
        <h1 class="w3-text-teal">Welcome to BOOKON</h1>
        <p>Submit your credentials to proceed. <a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></p>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>