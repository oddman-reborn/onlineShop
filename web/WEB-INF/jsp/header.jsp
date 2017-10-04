<%@page import="com.shop.entity.User"%>
<div class="row" style="background-color:#222222">
			<div class="col-md-3" >
				<img src="resources/images/logo.png" style="width:100px; length:70px"/>
			</div>
			
			<div class="col-md-6"></div>
			<div class="col-md-3">
                            <%try{
                                User user=(User)session.getAttribute("session");
                                int id=user.getId();
                                String name=user.getName();
                                if(id>0)
                                {%>
                                <b style="color: #449D44;font-size: 20px"><%= user.getName()%></b><br>
                                <a href="logout" style="color: #449D44">Logout</a>
                                <% }
                                    else{
                                %>
				
				<form action="login" ModelAttribute="login" method="POST" >
					<input type="text" name="email" placeholder="E-mail"></input>
					<input type="text" name="password" placeholder="Password"></input>
					<input class="btn btn-success" type="submit" value="Log in"></input>
				</form>
				
				<a href="userReg" style="color:#449D44" ><b>Register |</b> </a>   
				<a href="forgotPass" style="color:#449D44" ><b>Forgot Password </b></a>
                                <% }}
                                catch(Exception e)
                                    {%>
                                        <form action="login" ModelAttribute="login" method="POST" >
					<input type="text" name="email" placeholder="E-mail"></input>
					<input type="text" name="password" placeholder="Password"></input>
					<input class="btn btn-success" type="submit" value="Log in"></input>
				</form>
				
				<a href="userReg" style="color:#449D44" ><b>Register |</b> </a>   
				<a href="forgotPass" style="color:#449D44" ><b>Forgot Password </b></a>
                                 <%   }%>
                                
			</div>	
		</div>