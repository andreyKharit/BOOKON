<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BOOKON Login</title>
</head>
<body>
<form action="login" method="get">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="login">
    <span class="error">${error}</span>
</form>
</body>
</html>