<%@page import="entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/manageCustomer.css">
</head>
<body>
	<%
	ArrayList<Customer> listCustomers = (ArrayList<Customer>) request.getAttribute("listCustomers");
	%>
	<h1>
		You have
		<%=listCustomers.size()%>
		customer registered.
	</h1>
	<table class="table-showCustomer">
		<tr>
			<td style="padding-right: 30px;">Customer ID</td>
			<td style="padding-right: 30px;">Customer Name</td>
			<td style="padding-right: 30px;">User Name</td>
			<td style="padding-right: 30px;">Password</td>
			<td style="padding-right: 30px;">Customer Address</td>
			<td style="padding-right: 30px;">Customer Number Phone</td>
		</tr>
		<%
		for (int i = 0; i < listCustomers.size(); i++) {
		%>
		<tr>
			<td><%=listCustomers.get(i).getCustomerID()%></td>
			<td><%=listCustomers.get(i).getCustomerName()%></td>
			<td><%=listCustomers.get(i).getCustomerUserName()%></td>
			<td><%=listCustomers.get(i).getCustomerPass()%></td>
			<td><%=listCustomers.get(i).getCustomerAddress()%></td>
			<td><%=listCustomers.get(i).getCustomerPhone()%></td>
			<td><a
				href="ManageCustomerServlet?mode=delete&id=<%=listCustomers.get(i).getCustomerID()%>">
					<button>Delete</button>
			</a></td>
			<td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="home.jsp"><button>Back</button></a>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print("<h1>" + msg + "</h1>");
	}
	%>

</body>

</html>