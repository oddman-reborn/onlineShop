
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
                    <div class="row" >
                        <div class="col-md-6">
                        <form action="searchByOrderId" method="POST" style="width: 150px">
                            <input class="form-control" id="focusedInput" type="number" name="oid" placeholder="Order ID">
                            <input type="submit" class="btn btn-success" value="Search">
                        </form>
                        </div>
                        <div class="col-md-6" >
                            <form action="searchByStatus" method="POST" >
                                <select name="status" class="form-control" id="focusedInput" style="width: 150px;float: right">
                                <option value="All"> All</option>
                                <option value="All Pending">All Pending</option>
                                <option value="All Accepted">All Accepted</option>
                                <option value="All Delivered">All Delivered</option>
                            </select>
                                <br><br>
                                <input type="submit" class="btn btn-success" value="Search" style="float: right">
                            </form>
                        </div>
                    </div>
                    <h2>Order List</h2>
                    <table class="table table-hover">
                        <tr>
                            <th>Product Detail</th>
                            <th>Order Detail</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${orderList}" var="order">
                            <tr>
                                <c:forEach items="${productInfo}" var="product">
                                    <c:choose>
                                        <c:when test="${order.productId == product.id}">
                                            <td>
                                                <h4>Order ID: ${order.id}</h4>
                                                <img src="${product.imagePath}" style="height: 200px;width: 200px"> 
                                                <h4>Product ID: ${product.id}</h4>
                                                <h4>${product.name}</h4>
                                            </td>
                                            <td>
                                                <p>Deliver by: ${order.deliveryType}</p>
                                                <p>Total Unit: ${order.quantity}</p>

                                                <p>User ID: ${order.userId}</p>
                                                <p>Name: ${order.name}</p>
                                                <p>Contact: ${order.contactNo}</p>
                                                <label>Address</label><br>
                                                <textarea rows="4" cols="50" readonly>${order.address}</textarea>
                                                <p><b>Cost: ${order.price} tk</b></p>

                                            </td>
                                            <td>

                                                <c:if test="${order.status =='0'}">
                                                    <P>Pending</P>
                                                    </c:if>
                                                    <c:if test="${order.status == '1'}">
                                                    <p>Accepted</p>
                                                </c:if>
                                                <c:if test="${order.status == '2'}">
                                                    <p>Delivered</p>
                                                </c:if>
                                                <c:if test="${order.status == '3'}">
                                                    <p>Deleted</p>
                                                </c:if>

                                            </td>
                                            <td>
                                                <c:if test="${order.status != '1'}">
                                                    <a href="orderAccept?oid=${order.id}"><input type="submit" value="Accept" class="btn btn-success" > </a>
                                                </c:if>

                                                <c:if test="${order.status != 2}">
                                                    <a href="orderReject?oid=${order.id}" onclick="return confirm('Are you sure?')"><input type="submit" value="Reject" class="btn btn-success" > </a>
                                                </c:if>
                                                    
                                            </td>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </tr>
                        </c:forEach>

                    </table>


                </div>
            </div>

        </div>


        <%@ include file = "admin_footer.jsp" %>


    </div>


    <%@ include file = "js.jsp" %>
</body>



</html>