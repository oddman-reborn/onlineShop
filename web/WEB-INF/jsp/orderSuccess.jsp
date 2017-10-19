<%@include file="head.jsp" %>
<script type="text/javascript">
    window.alert("Your order placed successfully...");

window.document.location.href="myOrderList?userId=<%= user_id %>";
</script>