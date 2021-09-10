<%@page import="year.UserDao"%>
<jsp:useBean id="u" class="year.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=UserDao.clearseatplan(u);
if(i>0){
	%>
	<h2>Seatplan database cleared</h2>
	<jsp:include page="userform.html"></jsp:include>
	<jsp:include page="viewusers.jsp"></jsp:include>
<%

}else{
response.sendRedirect("adduser-error.jsp");
}
%>