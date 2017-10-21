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
			<div class="col-md-3"></div>
			
			<div class="col-md-6">
				
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
				<h2>Account History</h2>
                                <table class="table table-hover">
                                    <tr>
                                        <th>Date</th>
                                        <th>Recharge</th>
                                        <th>Purchase Cost</th>
                                        <th>Purchased Product ID</th>
                                    </tr>
                                    <c:forEach items="${history}" var="h">
                                        <tr>
                                            <td>${h.date}</td>
                                            <td>${h.credit}</td>
                                            <td>${h.debit}</td>
                                            <td>${h.productId}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                                
			</div>
			</div>
			
		</div>
		
		
		<%@ include file = "footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>