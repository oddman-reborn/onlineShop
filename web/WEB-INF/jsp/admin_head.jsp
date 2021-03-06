<%@page import="com.shop.entity.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%
    Admin admin_info= (Admin)session.getAttribute("session");
    String role=admin_info.getRole();
    if(!role.equals("Admin"))
        response.sendRedirect("error");
%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="resources/css/font.min.css"/>
	
	<link rel="stylesheet" type="text/css" href="resources/css/custom.css"/>
	<link rel="stylesheet" href="resources/themes/default/default.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="resources/themes/light/light.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="resources/themes/dark/dark.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="resources/themes/bar/bar.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="resources/css/nivo-slider.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
</head>

