<%@ include file = "head.jsp" %>
<%
    session.invalidate();
    user_id=0;
    response.sendRedirect("index");
%>