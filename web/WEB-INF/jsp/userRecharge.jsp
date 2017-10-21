<!DOCTYPE html>
<%@ include file = "head.jsp" %>


<body>
	<div class="container-fluid">
            <% if( user_id > 0){ %> 
		<%@include file="userHeader.jsp" %>
		<% }else {%>
                    <%@include file="header.jsp" %>
            <% } %>
		
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="col-md-2"></div>
			
			<div class="col-md-7">
				
				  <div class="container-fluid">
                                      <% if( user_id >0){ %>
                                      <%@include file="userMenubar.jsp" %>
                                      <%}else{ %>
                                        <%@include file="menubar.jsp" %>
                                      <% } %>
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
				<h2>Recharge</h2>
                                <div class="col-md-3">
                                    
                                </div>
                                <div class="col-md-6" style="background-color: #9acfea">
                                    <form class="form-horizontal" action="userRecharge" ModelAttribute="Recharge" method="POST">
                                        <input type="number" name="uid" value="<%= user_id %>" hidden>
                                        <label>Code no : <input type="text" name="code" class="form-control" id="focusedInput"></label>
                                        <label>Pine Code :<input type="number" name="pin" class="form-control" id="focusedInput"></label>
                                        
                                        <input type="submit" class="btn btn-success" value="Recharge">
                                    </form>
                                </div>
                                <div class="col-md-3"></div>
			</div>
			</div>
			
		</div>
		
		
		<%@ include file = "footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>