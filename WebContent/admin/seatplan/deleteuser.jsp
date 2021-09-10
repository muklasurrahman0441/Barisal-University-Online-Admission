<%@page import="seatplan.UserDao"%>
<jsp:useBean id="u" class="seatplan.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserDao.delete(u);
response.sendRedirect("SeatPlanReg.jsp");
%>