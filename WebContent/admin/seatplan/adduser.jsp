<%@page import="seatplan.UserDao"%>
<jsp:useBean id="u" class="seatplan.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=UserDao.save(u);
if(i>0){
response.sendRedirect("SeatPlanReg.jsp");
}
%>