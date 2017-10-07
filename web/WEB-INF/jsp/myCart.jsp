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
                    <h2>My Cart</h2>
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
                                                    <a href="viewCartProduct?pid=${product.id}"><input class="btn btn-success" type="submit"  value="View Detail"/></a>
                                                    <a href="cartDelete?pid=${product.id}" onclick="return confirm('Are you sure?')"><input class="btn btn-success" type="submit"  value="Remove"/></a>
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

        </div>


        <%@ include file = "footer.jsp" %>


    </div>


    <%@ include file = "js.jsp" %>
</body>



</html>