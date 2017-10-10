<%@page import="com.shop.entity.User"%>

<div class="row" style="background-color:#222222">
    <div class="col-md-3" >
        <img src="resources/images/logo.png" style="width:100px; length:70px"/>
    </div>

    <div class="col-md-6"></div>
    <div class="col-md-3">

        <%if (user_id > 0) {%>
        <p style="color:#449D44"><b><%= user.getName()%></b></p> 
        <a href="logout" style="color:#449D44" >Log out</a>
        <% } else {%>
        <form action="login" ModelAttribute="login" method="POST" >
            <input type="text" name="email" placeholder="E-mail" required></input>
            <input type="password" name="password" placeholder="Password" required></input>
            <input class="btn btn-success" type="submit" value="Log in"></input>
        </form>
        <a href="userReg" style="color:#449D44" ><b>Register |</b> </a>   
        <a href="forgotPass" style="color:#449D44" ><b>Forgot Password </b></a>
        <% }%>




    </div>	
</div>