<%@page import="com.shop.entity.User"%>
<%!static int user_id;User user=new User(); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%
    try{
         user =(User)session.getAttribute("session");
        int id=user.getId();
        if(id>0)
            user_id=id ;
        else 
            user_id=0;
    }
    catch(Exception e)
    {
        user_id=0;
    }
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

