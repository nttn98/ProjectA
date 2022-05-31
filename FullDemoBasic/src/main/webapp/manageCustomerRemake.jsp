<%@page import="entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<title>Manage Customer Page</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/manageProduct.css">
</head>
<body>
	<%@include file="checkLoginheader.jsp"%>
	<%
	ArrayList<Customer> listCustomers = (ArrayList<Customer>) request.getAttribute("listCustomers");
	int countCustomer = listCustomers.size();
	%>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Manage Customer</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-center">
						You have
						<%=countCustomer%>
						customers registered.
					</h3>
					<div>
						<table class="table">
							<thead class="thead-primary">
								<tr>
									<th>Customer ID</th>
									<th>Customer Name</th>
									<th>User Name</th>
									<th>Password</th>
									<th>Customer Address</th>
									<th>Number Phone</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < listCustomers.size(); i++) {
								%>
								<tr class="alert" role="alert">
									<td>
										<div class="customerID">
											<span><%=listCustomers.get(i).getCustomerID()%></span>
										</div>
									</td>
									<td>
										<div class="customerName">
											<span><%=listCustomers.get(i).getCustomerName()%></span>
										</div>
									</td>
									<td>
										<div class="customerUserNam">
											<span><%=listCustomers.get(i).getCustomerUserName()%></span>
										</div>
									</td>
									<td>
										<div class="customerPass">
											<span><%=listCustomers.get(i).getCustomerPass()%></span>
										</div>
									</td>
									<td>
										<div class="customerAddress">
											<span><%=listCustomers.get(i).getCustomerAddress()%></span>
										</div>
									</td>
									<td>
										<div class="customerNumberPhone">
											<span><%=listCustomers.get(i).getCustomerPhone()%></span>
										</div>
									</td>

									<td><a
										href="ManageCustomerServlet?mode=delete&id=<%=listCustomers.get(i).getCustomerID()%>"><button
												class="btn-product">Delete</button></a></td>
								</tr>
							</tbody>
							<%
							}
							%>
						</table>
						<br>
<%-- 						<% --%>
<!-- // 						String msg = (String) request.getAttribute("msg"); -->
<!-- // 						if (msg != null) { -->
<!-- // 							out.print(msg); -->
<!-- // 						} -->
<%-- 						%> --%>
						<br> <br> <a href="home.jsp"><button
								class="btn-product">Back</button></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>

