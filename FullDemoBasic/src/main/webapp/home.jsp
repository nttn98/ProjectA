<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/home.css">
<script type="text/javascript" src="jquery-3.5.1.min.js"></script>
<title>VieDeli Home Page</title>
</head>
<body>
	<!-- 	<h1>Welcome</h1> -->
	<!-- 	<a href="ManageProductServlet?mode=view">Product Management</a> -->
	<!-- 	<br> -->
	<!-- 	<a href="ManageCustomerServlet?mode=view">Customer Management</a> -->
	<!-- 	<br> -->
	<!-- 	<a href="LoginServlet?mode=logout">Logout</a> -->
	<%-- 	<%=request.getAttribute("msg")%> --%>

	<header> Welcome </header>

	<div class="container-fluid">
		<div class="row">
			<div class="col-2 left-side">
				<h2>Brand List</h2>
				<ul id="classGroup">
					<li><a href="ManageProductServlet?mode=view">Product
							Management</a></li>
					<li><a href="ManageCustomerServlet?mode=view">Customer
							Management</a></li>
				</ul>
			</div>
		</div>
		<a href="LoginServlet?mode=logout">Logout</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
		integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
		crossorigin="anonymous"></script>
</body>
</html>