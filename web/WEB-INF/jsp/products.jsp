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
                    <c:forEach items="${category}" var="cat"><br>
                        <div class="panel panel-defaul" style="background-color: #FFFCDD;border-style: solid;border-color: #449D44;">
                            <div class="panel-heading">
                                <h4>${cat}<h4></div>
                                        <div class="panel-body" >
                                            <c:forEach items="${productList}" var="p" end="3">
                                                <ul class="product" style="list-style: none;">
                                                    <li>
                                                        <a href="viewByProduct" style="text-decoration: none;color: #449D44">
                                                            <c:choose>
                                                                <c:when test="${cat==p.category}">
                                                                    <a href="viewByProduct?pid=${p.id}" style="text-decoration: none;color: #449D44">
                                                                    <b>${p.name}</b><br>
                                                                    <img src="${p.imagePath}" style="height: 150px;height: 150px;">
                                                                    <P>Price :${p.price}</P>
                                                                    <p>Brand :${p.brand}</p>
                                                                </c:when>
                                                            </c:choose>
                                                        </a>
                                                    </li>
                                                </ul>
                                            </c:forEach>
                                            
                                        </div>
                                        <a class="btn btn-success" style="float: right;" href="productList?category=${cat}">View more>></a>
                                        </div>
                                    </c:forEach>
                                    </div>
                                    </div>

                                    </div>


                                    <%@ include file = "footer.jsp" %>


                                    </div>


                                    <%@ include file = "js.jsp" %>
                                    </body>



                                    </html>