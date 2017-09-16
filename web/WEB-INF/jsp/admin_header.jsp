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
				
				<form action="login" ModelAttribute="login" method="POST" >
					<input type="text" name="email" placeholder="E-mail"></input>
					<input type="text" name="password" placeholder="Password"></input>
					<input class="btn btn-success" type="submit" value="Log in"></input>
				</form>
				
                            <p style="color:#449D44"><%= admin_nfo.getName()%></p> 
				<a href="logout" style="color:#449D44" ><b>Log out</b></a>
			</div>	
		</div>