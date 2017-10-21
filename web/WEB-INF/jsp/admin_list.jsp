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
                            <div class="col-md-2">
                                
                            </div>
                            <div class="col-md-8">
                                <h2>Admin List</h2>
                                <table class="table table-hover">
                            <tr>
                                <th>ID#</th>
                                <th>Name</th>
                                <th>Username</th>
                                <th>Role</th>
                                <th>Designation</th>
                            </tr>

                            <c:forEach items="${adminList}" var="admin">
                                <tr>
                                    <td>${admin.id}</td>
                                    <td>${admin.name}</td>
                                    <td>${admin.username}</td>
                                    <td>${admin.role}</td>
                                    <td>${admin.designation}</td>
                                </tr>
                            </c:forEach>
                                </table>
                            </div>
                            <div class="col-md-2">
                                
                            </div>
                                
			</div>
			</div>
			
		</div>
		
		
		<%@ include file = "admin_footer.jsp" %>
		
	
	</div>


<%@ include file = "js.jsp" %>
</body>



</html>