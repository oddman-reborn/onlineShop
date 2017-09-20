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
                    <h2>Upload Product</h2>
                    <div class="panel-body" style="color: #449D44;background-color: #262626">
                        <form class="form-horizontal" role="form" ModelAttribute="Product" action="admin_uploadProduct" method="POST" enctype="multipart/form-data">
                            <div class="inp" style="margin-left: 300px;margin-right: 300px">
                                <label >Name</label>
                                <input class="form-control" id="focusedInput" type="text" name="name" required ><br>

                                <label >Price</label>
                                <input class="form-control" id="focusedInput" type="number" name="price" required ><br>

                                <label>Category</label>
                                <select name="category" class="form-control" id="focusedInput" required>
                                    <option value=""></option>
                                    <option value="Computer(Laptop)">Computer(Laptop)</option>
                                    <option value="Computer(Desktop)">Computer(Desktop)</option>
                                    <option value="Electronics goods">Electronic goods</option>
                                    <option value="Hard Disk">Hard Disk</option>
                                    <option value="Monitor">Monitor</option>
                                    <option value="Mouse">Mouse</option>
                                    <option value="KeyBoard">KeyBoard</option>

                                </select>

                                <label>Brand</label>
                                <select name="brand" class="form-control" id="focusedInput">
                                    <option value=""></option>
                                    <option value="HP">HP</option>
                                    <option value="Dell">Dell</option>
                                    <option value="Asus">Asus</option>
                                    <option value="Sony">Sony</option>
                                    <option value="A4Tech">A4Tech</option>
                                    <option value="LG">LG</option>
                                    <option value="Hitachi">Hitachi</option>
                                    <option value="WD">WD</option>

                                </select>

                                <label>Unit</label>
                                <input class="form-control" id="focusedInput" type="number" name="unitAvailable" required ><br>


                                <label>Details</label>
                                <textarea class="form-control" id="focusedInput" name="detail" rows="4" cols="20"></textarea>

                                <label>Choose image</label>
                                <input class="form-control" id="focusedInput" type="file" name="file" />
                                
                                <br>
                                <input style="width: 200px;margin-left: 200px" class="btn btn-success" type="submit" value="Upload"/>

                            </div>
                        </form>
                    </div>

                </div>
            </div>

        </div>


        <%@ include file = "admin_footer.jsp" %>


    </div>


    <%@ include file = "js.jsp" %>
</body>



</html>