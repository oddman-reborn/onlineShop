<%@include file="head.jsp" %>
<script type="text/javascript">
    window.alert("You dont have enough balance to place order...");

window.document.location.href="myOrderList?userId=<%= user_id %>";
</script>