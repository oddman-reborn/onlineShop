
<%@page import="com.shop.entity.User"%>
<%
    User user=(User)session.getAttribute("session");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Dash</h1>
        <%= user.getName()%>
        <a href="logout">Logout</a>
    </body>
</html>
