<%--
  ~ 2020
  ~ Last updated: 4/2/20, 1:03 AM
  ~ Author: Andrey Kharitonenko
  --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BOOKON|Access Error</title>
</head>
<body>
<%@include file="header-bar.jsp" %>

<div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container" style="text-align:center">
        <h1 class="w3-text-teal">401 Access Denied</h1>
        <p><a href="${pageContext.request.contextPath}/login.jsp">LOGIN</a></p>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>