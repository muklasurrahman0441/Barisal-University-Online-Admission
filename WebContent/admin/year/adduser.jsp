<%@page import="year.UserDao"%>
<jsp:useBean id="u" class="year.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=UserDao.save(u);
if(i>0){
response.sendRedirect("YearReg.jsp");
}
%>