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
				<h2>Upload Credit Card</h2>
                                <div class="col-md-3">
                                    
                                </div>
                                <div class="col-md-6" style="background-color: #122b40">
                                    <p>Choose Text(.txt) File Only</p>
                                    <form class="form-horizontal" role="form" action="uploadCreditCard" method="POST" enctype="multipart/form-data">
                                        <label>Select File for Code no List:</label>
                                        <input type="file" name="creditCardCode" class="form-control" id="focusedInput" required>
                                        <label>Select File for Pin Code List:</label>
                                        <input type="file" name="creditCardPin" class="form-control" id="focusedInput" required>
                                        <label>Select File for Balance List :</label>
                                        <input type="file" name="creditCardBalance" class="form-control" id="focusedInput" required>
                                        <br>
                                        <input type="submit" class="btn btn-success" value="Upload">
                                        
                                    </form>
                                    <br>
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