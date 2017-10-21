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
                    <h2>Order List</h2>
                    <div class="main_view" style="background-color: #E8E9EB">
                        <table class="table table-hover">
                            <tr>
                                <th>Image</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach items="${userCart}" var="cart">
                                <tr>
                                    <c:forEach items="${productDetail}" var="product">
                                        <c:choose>
                                            <c:when test="${cart.productId==product.id}">
                                                <td><img src="${product.imagePath}" style="height: 150px;width: 150px"></td>
                                                <td>${product.name}</td>
                                                <td>${cart.price}</td>
                                                <td>${cart.quantity}</td>
                                                <td>
                                                    <a href="viewCartProduct?pid=${product.id}&cid=${cart.id}"><input class="btn btn-success" type="submit"  value="View Detail"/></a>
                                                    <a href="cartDelete?cid=${cart.id}" onclick="return confirm('Are you sure?')"><input class="btn btn-success" type="submit"  value="Remove"/></a>
                                                    <a href="moveToCart?cid=${cart.id}" ><input class="btn btn-success" type="submit"  value="Move into Cart"/></a>
                                                </td>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>

                                </tr>
                            </c:forEach>


                        </table>
                        <h4>Total Balance : ${credit}</h4>
                        <h4>Total Cost : ${cost}</h4>
                        
                        <div class="form-horizontal" >
                            <h2>Oreder Deatils</h2>
                            <hr style="border-top: 1px solid #4cae4c">
                            <div class="col-md-2" ></div>
                            <div class="col-md-6" style="background-color: #121E31">
                                <form action="userPlaceOrder" class="form-horizontal" modelAttribute="orderInfo" method="POST" >
                                    <input type="number" name="userId" value="<%= user_id %>" hidden>
                                    <input type="number" name="credit" value="${credit}" hidden>
                                    <input type="number" name="cost" value="${cost}" hidden>
                                <label>Name:</label><input type="text" name="name"  class="form-control" id="focusedInput" required>
                                <label>Contact Mo:</label><input type="number" name="contactNo" class="form-control" id="focusedInput" required>
                                <label>Address</label><input type="text" name="address" class="form-control" id="focusedInput" required>
                                <label>Delivery Type</label>
                                <select name="deliveryType" class="form-control" id="focusedInput" required>
                                    <option value=""></option>
                                    <option value="Home Delivery">Home Delivery</option>
                                    <option value="By Mail">By Mail</option>
                                    <option value="Come in person">Come in person</option>
                                </select>
                                <br>
                                <input type="submit" class="btn btn-success" value="Place Order"><br><br>
                                
                            </form>
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <%@ include file = "footer.jsp" %>


    </div>


    <%@ include file = "js.jsp" %>
</body>



</html>