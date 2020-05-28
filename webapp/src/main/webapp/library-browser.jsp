<%--
  ~ 2020
  ~ Last updated: 4/2/20, 1:03 AM
  ~ Author: Andrey Kharitonenko
  --%>

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<title>BOOKON|Library</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
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
<%@include file="sidebar.jsp" %>
>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

    <div class="w3-row w3-padding-64">
        <div class="w3-twothird w3-container">

            <form action="create_book" method="post">
                <div class="container">
                    Book:
                    <input class="input-group-text" type="text" name="book">
                    Author:
                    <input class="dropdown input-group-text" type="text" name="author">
                    Publisher:
                    <input class="dropdown-item-text" type="text" name="publisher">
                    <p>Genre: </p>
                    <input class="custom-checkbox" type = "checkbox" name = "genres" value="1"/> Mystery
                    <input type = "checkbox" name = "genres" value="2"/> Comedy
                    <input type = "checkbox" name = "genres" value="3"/> Romance
                    <input type = "checkbox" name = "genres" value="4"/> Classic
                    <input type = "checkbox" name = "genres" value="5"/> Thriller
                    <input type = "checkbox" name = "genres" value="6"/> Horror
                    <input type = "checkbox" name = "genres" value="7"/> Non-Fiction
                    <input type="submit" class="btn btn-primary" value="Create">
                </div>
            </form>

            <h1 class="w3-text-teal">Library</h1>
            <p>

                <%--            <form action="library-browser" method="post">--%>

            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>
                        Title
                    </th>
                    <th>
                        Author
                    </th>
                    <th>
                        Publisher
                    </th>
                    <th>
                        Status
                    </th>
                    <th>
                        Actions
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.books}" var="book">
                    <tr>
                        <td>
                            <c:out value="${book.name}"/>
                        </td>
                        <td>
                            <c:out value="${book.bkAuthor.name}"/>
                        </td>
                        <td>
                            <c:out value="${book.bkPublisher.publisherName}"/>
                        </td>
                        <td>
                            <c:if test="${book.bookStatus == 1}">
                                <span class="badge badge-info">Available</span>
                            </c:if>
                            <c:if test="${book.bookStatus != 1}">
                                <span class="badge badge-danger">Unavailable</span>
                            </c:if>
                        </td>
                        <td>
                            action here
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <%--            </form>--%>

            <%--            <table border="1" cellpadding="5">--%>
            <%--                <tr>--%>
            <%--                    <th>ID</th>--%>
            <%--                    <th>Login</th>--%>
            <%--                    <th>Status</th>--%>
            <%--                </tr>--%>
            <%--                <c:forEach var="user" items="${requestScope.subjects}">--%>
            <%--                    <tr>--%>
            <%--                        <td><c:out value="${user.userId}"/></td>--%>
            <%--                        <td><c:out value="${user.userName}"/></td>--%>
            <%--                        <td><c:out value="${user.userStatus}"/></td>--%>
            <%--                        <c:if test="${!user.userStatus.equals('admin')}">--%>
            <%--                            <td><input type="submit" name="edit" value="Edit" onClick="window.location='editUser.jsp';"--%>
            <%--                                       style="background-color:#49743D;font-weight:bold;color:#ffffff;"></td>--%>
            <%--                        </c:if>--%>
            <%--                        <c:if test="${!user.userStatus.equals('admin')}">--%>
            <%--                            <td><button type="submit" formmethod="post" name="delete" value="${user.userId}">delete</button></td>--%>
            <%--                        </c:if>--%>
            <%--                    </tr>--%>
            <%--                </c:forEach>--%>
            <%--            </table>--%>
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