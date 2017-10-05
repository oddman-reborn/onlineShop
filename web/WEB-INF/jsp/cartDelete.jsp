<%@include file="header.jsp" %>
<script type="text/javascript">
    window.alert("Deleted from Cart...");

window.document.location.href="myCart?userId=<%= user_id %>";
</script>