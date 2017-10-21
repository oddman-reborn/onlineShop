<script type="text/javascript">
    window.alert("Please Login to get full access...");
</script>
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
                    <h2>Login Here</h2>
                    <div class="panel panel-defaul" style="background-color: #FFFCDD;border-style: solid;border-color: #449D44;width: 500px;margin-left: 260px">
                        <form ModelAttribute="login" method="POST" action="login">
                            <label>Email </label>
                            <input style="width: 300px;margin-left: 40px" class="form-control" id="focusedInput" type="text" name="email" required ><br>
                            
                            <label>Password </label>
                            <input style="width: 300px;margin-left: 40px" class="form-control" id="focusedInput" type="password" name="password" required ><br>
                            
                            <input style="width: 200px;margin-left: 40px" class="btn btn-success" type="submit" name="reg" value="Login"/><br><br>
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
