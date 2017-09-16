<!DOCTYPE html>
<%@ include file = "admin_head.jsp" %>


<body>
	<div class="container-fluid">
		<%@include file="admin_header.jsp" %>
		
		
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="col-md-3"></div>
			
			<div class="col-md-6">
				
				  <div class="container-fluid">
                                      <%@include file="admin_menubar.jsp" %>
				  </div>
				
			</div>
			</nav>

		</div>

		<div class="row">

			<div class="col-md-12">
			<div class="main_view">
				<h2>Upload Product</h2>
                                <div class="panel-body" style="color: #449D44;background-color: #262626">
                                    <form class="form-horizontal" role="form" ModelAttribute="Product" action="insert_product" method="POST">
                                        <div class="inp" style="margin-left: 250px">
                                            <label >Name</label>
                                            <input class="form-control" id="focusedInput" type="text" name="name" required ><br>
                                            
                                            <label >Price</label>
                                             <input class="form-control" id="focusedInput" type="number" name="price" required ><br>
                                             
                                             <label>Category</label>
                                             <select name="category" class="form-control" id="focusedInput">
                                                 
                                                 <option value="Computer(Laptop)">Computer(Laptop)</option>
                                                 <option value="Computer(Laptop)">Computer(Desktop)</option>
                                                 <option value="Electronics goods">Electronic goods</option>
                                                 <option value="Hard Disk">Hard Disk</option>
                                                 <option value="Monitor">Monitor</option>
                                                 <option value="Mouse">Mouse</option>
                                                 <option value="KeyBoard">KeyBoard</option>
                                             </select>
                                        </div>
                                    </form>
                                </div>
                                
			</div>
			</div>
			
		</div>
		
		
		<%@ include file = "admin_footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>