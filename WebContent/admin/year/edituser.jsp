
<%@page import="year.UserDao"%>
<jsp:useBean id="u" class="year.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int i=UserDao.update(u);
response.sendRedirect("YearReg.jsp");
%>