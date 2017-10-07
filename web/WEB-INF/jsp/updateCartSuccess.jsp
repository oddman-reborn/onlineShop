<%@include file="header.jsp" %>
<script type="text/javascript">
    window.alert("Updated product from Cart...");

window.document.location.href="myCart?userId=<%= user_id %>";
</script>