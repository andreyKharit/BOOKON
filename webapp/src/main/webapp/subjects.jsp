<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<title>BOOKON|Users List</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    html, body, h1, h2, h3, h4, h5, h6 {
        font-family: "Roboto", sans-serif;
    }

    .w3-sidebar {
        z-index: 3;
        width: 250px;
        top: 43px;
        bottom: 0;
        height: inherit;
    }
</style>
<body>

<!-- Navbar -->
<%@include file="header-bar.jsp" %>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
    <a href="javascript:void(0)" onclick="w3_close()"
       class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
        <i class="fa fa-remove"></i>
        <h4 class="w3-bar-item"><b>Menu</b></h4>
        <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/main-menu.jsp">Welcome</a>
        <c:if test="${sessionScope.status.equals('admin')}"><a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/subjects">Browse Users</a></c:if>
        <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/logout">Log Out</a>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu"
     id="myOverlay"></div>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

    <div class="w3-row w3-padding-64">
        <div class="w3-twothird w3-container">
            <h1 class="w3-text-teal">Users List</h1>
            <p>
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>Login</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="user" items="${requestScope.subjects}">
                    <tr>
                        <td><c:out value="${user.userId}"/></td>
                        <td><c:out value="${user.userName}"/></td>
                        <td><c:out value="${user.userStatus}"/></td>
                        <c:if test="${!user.userStatus.equals('admin')}"><td><input type="button" name="edit" value="Edit" onClick="window.location='editUser.jsp';" style="background-color:#49743D;font-weight:bold;color:#ffffff;"> </td></c:if>
                        <c:if test="${!user.userStatus.equals('admin')}"><td><input type="button" name="delete" value="Delete" onClick="window.location='deleteUser.jsp';"style="background-color:#ff0000;font-weight:bold;color:#ffffff;"></td></c:if>
                    </tr>
                </c:forEach>
            </table>
            </p>
        </div>
    </div>

    <!-- Pagination -->
    <%--    <div class="w3-center w3-padding-32">--%>
    <%--        <div class="w3-bar">--%>
    <%--            <a class="w3-button w3-black" href="#">1</a>--%>
    <%--            <a class="w3-button w3-hover-black" href="#">2</a>--%>
    <%--            <a class="w3-button w3-hover-black" href="#">3</a>--%>
    <%--            <a class="w3-button w3-hover-black" href="#">4</a>--%>
    <%--            <a class="w3-button w3-hover-black" href="#">5</a>--%>
    <%--            <a class="w3-button w3-hover-black" href="#">»</a>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%@include file="footer.jsp" %>

    <!-- END MAIN -->
</div>

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

</body>
</html>