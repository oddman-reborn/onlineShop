<%@include file="head.jsp" %>
<script type="text/javascript">
    window.alert("Moved into Cart...");

window.document.location.href="myOrderList?userId=<%= user_id %>";
</script>