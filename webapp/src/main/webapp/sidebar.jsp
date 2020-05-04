<%--
  ~ Last updated: 4/22/20, 4:46 PM
  ~ Author: Andrey Kharitonenko
  --%>

<%--
  Created by IntelliJ IDEA.
  User: poppy
  Date: 4/22/2020
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
    .w3-sidebar {
        z-index: 3;
        width: 250px;
        top: 43px;
        bottom: 0;
        height: inherit;
    }
</style>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
    <a href="javascript:void(0)" onclick="w3_close()"
       class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
        <i class="fa fa-remove"></i>
        <h4 class="w3-bar-item"><b>Menu</b></h4>

        <a class="w3-bar-item w3-button w3-hover-black"
           href="${pageContext.request.contextPath}/main-menu.jsp">Welcome</a>

        <a class="w3-bar-item w3-button w3-hover-black"
           href="${pageContext.request.contextPath}/library-browser.jsp">Browse Library</a>

        <c:if test="${sessionScope.status.equals('admin')}"><a class="w3-bar-item w3-button w3-hover-black"
                                                               href="${pageContext.request.contextPath}/subjects">Browse Users</a></c:if>

        <a class="w3-bar-item w3-button w3-hover-black" href="${pageContext.request.contextPath}/logout">Log Out</a>
</nav>

<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu"
     id="myOverlay"></div>