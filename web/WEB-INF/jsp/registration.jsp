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
                    <div class="panel-body" style="color: #449D44;background-color: #262626">
                        <h1 style="text-align: center">User Registration</h1>
                        <form class="form-horizontal" role="form" ModelAttribute="User" action="insert_user" method="POST">
                            <div class="form-group">
                              
                              <div class="col-md-10" >
                                  <div class="inp" style="margin-left: 250px">
                                  <label >Name</label>
                                  <input class="form-control" id="focusedInput" type="text" name="name" required ><br>
                                  
                                  <label >Email</label>
                                  <input class="form-control" id="focusedInput" type="email" name="email" required ><br>
                                  
                                  <label >Password</label>
                                  <input class="form-control" id="focusedInput" type="password" name="password" required="8"><br>
                                  
                                  
                                  <label >Contact</label>
                                  <input class="form-control" id="focusedInput" type="number" name="contact"  ><br>
                                  
                                  <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" name="reg" value="Register"/>
                                  </div>
                                  
                              </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <%@ include file = "footer.jsp" %>


    </div>


    <%@ include file = "js.jsp" %>
</body>



</html>