<%@include file="head.jsp" %>
<script type="text/javascript">
    window.alert("Added to Order List...");

window.document.location.href="myCart?userId=<%= user_id %>";
</script>