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
                                <div class="panel-body" style="color: #449D44;border-bottom-color: #449D44">
                                    <c:forEach items="${category}" var="cat">
                                        <p>${cat.category}</p>
                                        <c:forEach items="${cat}" var="p">
                                            <p>${p.name}</p>
                                        </c:forEach>
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