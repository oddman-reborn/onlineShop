<!DOCTYPE html>
<%@ include file = "head.jsp" %>


<body>
	<div class="container-fluid">
		<%@include file="header.jsp" %>
		
		
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="col-md-3"></div>
			
			<div class="col-md-6">
				
				  <div class="container-fluid">
                                      <%@include file="menubar.jsp" %>
				  </div>
				
			</div>
			</nav>

		</div>
		
		
		<div class="row">
			<div class="col-md-9">
				<div id="wrapper">
                                    <%@include file="slider.jsp" %>	
				</div>
			</div>
			
			
			
			<div class="col-md-3">
                            <%@include file="search_social.jsp" %>
			</div>
			
			
		</div>
		
		
		<div class="row">
			<div class="col-md-2">
                            <%@include file="category.jsp" %>
			</div>
			
			
			<div class="col-md-10">
			<div class="main_view" style="background-color: #E8E9EB">
				<h2>Product Details</h2>
                                <hr style="border-top: 1px solid #4cae4c">
                                <div class="col-md-4">
                                    <img src="${product.imagePath}" style="height: 330px;width: 330px;">
                                    <form action="addtoCart" method="POST">
                                        <label>Quantity: </label>
                                        <select name="quantity"  id="focusedInput" required>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select><br>
                                        <a class="btn btn-success" >Add to Cart</a><br><br>
                                    </form>
                                    
                                </div>
                                <div class="col-md-6">
                                    <p style="font-size: 25px">Name: ${product.name}</p>
                                    <p style="font-size: 25px;color: #555555">Category: ${product.category}</p>
                                    <p style="font-size: 20px;color: #555555">Price: ${product.price} Tk</p>
                                    <p style="font-size: 20px;color: #555555">Brand: ${product.brand} </p>
                                    <label>Details</label>
                                    <textarea class="form-control" id="focusedInput" name="detail" rows="6" readonly>${product.detail}</textarea>
                                </div>
                                
			</div>
                        <hr style="border-top: 1px solid #4cae4c">
			</div>
			
		</div>
		
		
		<%@ include file = "footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>