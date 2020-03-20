<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/26/20, 2:48 AM
  ~ Author: Andrey Kharitonenko
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

<!-- Header -->
<div class="w3-top">
    <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-theme-l1">BOOKON</a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">
            <c:if test="${sessionScope.authorized==true}">Authorized as </c:if>
        </a>
    </div>
</div>