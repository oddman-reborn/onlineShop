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
        <div class="row" style="background-color: #4CAF50;color: white">
            <div class="col-md-3">
                <form action="admin_searchById" method="POST">
                    <label>Product ID</label><input class="form-control" id="focusedInput" type="number" name="id" placeholder="ID" required style="width: 100px">
                    <input style="width: 100px;border: 2px solid #2b542c" class="btn btn-success" type="submit" value="Search"/>

                </form>
            </div>
            <div class="col-md-3">
                <form action="admin_searchByCategory" method="POST">
                    <label>Category</label>
                    <select name="category" class="form-control" id="focusedInput" style="width: 200px" required>
                        <option value="">Select</option>
                        <option value="Computer(Laptop)">Computer(Laptop)</option>
                        <option value="Computer(Desktop)">Computer(Desktop)</option>
                        <option value="Electronics goods">Electronic goods</option>
                        <option value="Hard Disk">Hard Disk</option>
                        <option value="Monitor">Monitor</option>
                        <option value="Mouse">Mouse</option>
                        <option value="KeyBoard">KeyBoard</option>

                    </select>
                    <input style="width: 100px;border: 2px solid #2b542c" class="btn btn-success" type="submit" value="Search"/>

                </form>
            </div>
            <div class="col-md-3">
                <form action="admin_searchByBrand" method="POST">
                    <label>Brand</label>
                    <select name="brand" class="form-control" id="focusedInput" style="width: 200px" required>
                        <option value="">Select</option>
                        <option value="HP">HP</option>
                        <option value="Dell">Dell</option>
                        <option value="Asus">Asus</option>
                        <option value="Sony">Sony</option>
                        <option value="A4Tech">A4Tech</option>
                        <option value="LG">LG</option>
                        <option value="Hitachi">Hitachi</option>
                        <option value="WD">WD</option>

                    </select>
                    <input style="width: 100px;border: 2px solid #2b542c" class="btn btn-success" type="submit" value="Search"/>
                </form>
            </div>
            <div class="col-md-3">
                <form action="admin_sortByQuantity" method="POST">
                    <label>Sort By</label>
                    <select name="sort" class="form-control" id="focusedInput" style="width: 200px" required>
                        <option value="">Select</option>
                        <option value="1">Ascending Order</option>
                        <option value="2">Descending Order</option>
                        
                    </select>
                    <input style="width: 100px;border: 2px solid #2b542c" class="btn btn-success" type="submit" value="Sort"/>
                </form>
            </div>
        </div>
        <div class="row">

            <div class="col-md-12">
                <div class="main_view">

                    <h4>Product List</h4>

                    <table class="table table-hover">
                        <tr>
                            <th>ID#</th>
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
                                <td><textarea class="form-control" id="focusedInput" name="detail" rows="4" cols="15" readonly>${product.detail}</textarea></td>
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