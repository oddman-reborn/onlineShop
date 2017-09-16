<%@page import="com.shop.entity.Admin"%>
<%
    Admin admin_info= (Admin)session.getAttribute("session");
    String role=admin_info.getRole();
    if(!role.equals("Admin"))
        response.sendRedirect("error");
%>

<div class="row" style="background-color:#222222">
			<div class="col-md-3" >
				<img src="resources/images/logo.png" style="width:100px; length:70px"/>
			</div>
			
			<div class="col-md-6"></div>
			<div class="col-md-3">
				
                            <p style="color:#449D44"><b><%= admin_info.getName()%></b></p> 
				<a href="logout" style="color:#449D44" >Log out</a>
			</div>	
		</div>