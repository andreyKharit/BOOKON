<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/19/20, 12:44 AM
  ~ Author: Andrey Kharitonenko
  --%>
<%--TODO jstl try--%>

<%@include file="footer.jsp" %>

<head>
    <title>BOOKON|Books Browser</title>
</head>
<body>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
    <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
        <i class="fa fa-remove"></i>
        <h4 class="w3-bar-item"><b>Menu</b></h4>
        <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/main-menu.jsp">Welcome</a>
        <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/subjects">Browse</a>
        <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/logout">Log Out</a>
</nav>

<script>
    // Get the Sidebar
    var mySidebar = document.getElementById("mySidebar");

    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");

    // Toggle between showing and hiding the sidebar, and add overlay effect
    function w3_open() {
        if (mySidebar.style.display === 'block') {
            mySidebar.style.display = 'none';
            overlayBg.style.display = "none";
        } else {
            mySidebar.style.display = 'block';
            overlayBg.style.display = "block";
        }
    }

    // Close the sidebar with the close button
    function w3_close() {
        mySidebar.style.display = "none";
        overlayBg.style.display = "none";
    }
</script>

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