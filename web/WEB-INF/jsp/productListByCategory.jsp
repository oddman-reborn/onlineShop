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
			<div class="main_view">
				<h2>Display</h2>
                                <div class="panel panel-defaul" style="background-color: #FFFCDD;border-style: solid;border-color: #449D44;">
                                <c:forEach items="${productList}" var="product">
                                    <table class="table table-hover">
                                        <tr>
                                            <td><img src="${product.imagePath}" style="width: 150px;height: 150px;" ></td>
                                            <td>
                                                <label style="font-size: 25px;float: left">Name :${product.name}</label><br><br>
                                                <label style="font-size: 20px;color: #555555;">Brand :${product.brand}</label><br>
                                                <label style="font-size: 20px;color: #555555;">Price :${product.price}</label><br>
                                            </td>
                                            <td>
                                                <a href="viewByProduct?pid=${product.id}"><input class="btn btn-success" type="submit"  value="View Details"/></a>
                                                <a href="addToCart?pid=${product.id}"><img src="resources\images\addtocart-green.png" style="width: 280px" /></a>
                                            </td>
                                        </tr>
                                    </table>
                                </c:forEach>
                                </div>           
			</div>
			</div>
			
		</div>
		
		
		<%@ include file = "footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>