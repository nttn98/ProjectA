
<%
String logedUser = (String) session.getAttribute("logedUser");
if (logedUser != null) {
	out.println("<p>hello user " + logedUser + "</p>");
	out.println("<a href='LoginServlet?mode=logout'><button>logout</button></a>");
} else {
	out.println("<p>You are not loged in</p>");
}
%>