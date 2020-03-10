<%--
  ~ Copyright (c) 2020
  ~ Last updated: 2/26/20, 2:48 AM
  ~ Author: Andrey Kharitonenko
  --%>

<%--
  Created by IntelliJ IDEA.
  User: poppy
  Date: 2/26/2020
  Time: 2:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Header</title>
</head>
<header>
    <nav class="navbar fixed-top navbar-expand-md flex-nowrap navbar-new-top">
        <a href="/" class="navbar-brand"><img src="#" alt=""/>BOOKON</a>
        <ul class="nav navbar-nav mr-auto"></ul>
        <ul class="navbar-nav flex-row">
            <li class="nav-item">
                <a class="nav-link px-2">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link px-2">Link</a>
            </li>
            <li class="nav-item">
                <button type="button" class="header-btn">Button</button>
            </li>
        </ul>
        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbar2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
    <nav class="navbar fixed-top navbar-expand-md navbar-new-bottom">
        <div class="navbar-collapse collapse pt-2 pt-md-0" id="navbar2">

            <ul class="navbar-nav w-100 justify-content-center px-3">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">Link</a>
                </li>
            </ul>
        </div>
    </nav>
</header>