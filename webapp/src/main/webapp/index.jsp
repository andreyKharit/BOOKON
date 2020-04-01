<%--
  ~ 2020
  ~ Last updated: 4/2/20, 1:03 AM
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
        <p>New here? <a href="${pageContext.request.contextPath}/register.jsp">REGISTRATION FORM</a></p>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>