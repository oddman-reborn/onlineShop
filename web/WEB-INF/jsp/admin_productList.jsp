<!DOCTYPE html>
<%@ include file = "admin_head.jsp" %>


<body>
    <div class="container-fluid">
        <%@include file="admin_header.jsp" %>


        <div class="row">
            <nav class="navbar navbar-inverse">
                <div class="col-md-3"></div>

                <div class="col-md-6">

                    <div class="container-fluid">
                        <%@include file="admin_menubar.jsp" %>
                    </div>

                </div>
            </nav>

        </div>

        <div class="row">

            <div class="col-md-12">
                <div class="main_view">
                    <h4>Product List</h4>

                    <table class="table table-hover">
                        <tr>
                            <th>ID</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Unit</th>
                            <th>Category</th>
                            <th>Detail</th>
                            <th>Price</th>
                            <th>Brand</th>
                            <th>Action</th>
                        </tr>
                        
                        <c:forEach items="${productList}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td><img src="${product.imagePath}"></td>
                            <td>${product.name}</td>
                            <td>${product.unitAvailable}</td>
                            <td>${product.category}</td>
                            <td>${product.detail}</td>
                            <td>${product.price}</td>
                            <td>${product.brand}</td>
                            <td>
                                <a href="admin_updateProduct?id=${product.id}"><input class="btn btn-success" type="submit"  value="Update"/></a>
                                <a href="admin_deleteProduct?id=${product.id}" onclick="return confirm('Are you sure?')"><input class="btn btn-success" type="submit"  value="Remove"/></a>
                            </td>
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