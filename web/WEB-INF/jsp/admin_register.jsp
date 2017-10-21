<!DOCTYPE html>
<%@ include file = "admin_head.jsp" %>


<body>
	<div class="container-fluid">
		<%@include file="admin_header.jsp" %>
		
		
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="col-md-2"></div>
			
			<div class="col-md-10">
				
				  <div class="container-fluid">
                                      <%@include file="admin_menubar.jsp" %>
				  </div>
				
			</div>
			</nav>

		</div>

		<div class="row">

			<div class="col-md-12">
			<div class="main_view">
                            <div class="col-md-3">
                                
                            </div>
                            <div class="col-md-6">
				<h2>Register New Admin</h2>
                                <form class="form-horizontal" role="form" ModelAttribute="Admin" action="admin_register" method="POST">
                                    <label >Name</label>
                                    <input class="form-control" id="focusedInput" type="text" name="name" required ><br>
                                    
                                    <label>Username</label>
                                    <input class="form-control" id="focusedInput" type="text" name="username" required ><br>
                                    
                                    <label>Password</label>
                                    <input class="form-control" id="focusedInput" type="text" name="password" required ><br>
                                    
                                    <input class="form-control" id="focusedInput" type="hidden" name="role" value="Admin" required><br>
                                    
                                    <label>Designation</label>
                                    <input class="form-control" id="focusedInput" type="text" name="designation" required ><br>
                                    
                                    <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Register"/><br><br>
                                </form>
                                </div>
                            <div class="col-md-3">
                                
                            </div>
			</div>
			</div>
			
		</div>
		
		
		<%@ include file = "admin_footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>