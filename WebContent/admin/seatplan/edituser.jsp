<%@page import="seatplan.UserDao"%>
<jsp:useBean id="u" class="seatplan.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=UserDao.update(u);
response.sendRedirect("SeatPlanReg.jsp");
%>