<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/register.css">
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<script language="javascript">
	function validateForm() {	
		let customerName = document.forms["myForm"]["customerName"].value;
		if (customerName == "") {
			alert("Name must be filled out");
			return false;
		}

		// 	name.match("^[A-Za-z]{1,20}, [A-Za-z]{1,20}, [A-Za-z]{1,20}")
		let customerUserName = document.forms["myForm"]["customerUserName"].value;
		if (customerUserName == "") {
			alert("Username must be filled out");
			return false;
		}
		let customerPass = document.forms["myForm"]["customerPass"].value;
		if (customerPass == "") {
			alert("Password must be filled out");
			return false;
		}
		let customerAddress = document.forms["myForm"]["customerAddress"].value;
		if (customerAddress == "") {
			alert("Address must be filled out");
			return false;
		}
		let customerPhone = document.forms["myForm"]["customerPhone"].value;
		if (customerPhone == "") {
			alert("Phone must be filled out");
			return false;
		}
	}
</script>
<body>
	<%-- 	<%@include file="checkLoginheader.jsp"%> --%>
	<!-- 	<form action="RegisterServlet" method="POST"> -->
	<!-- 		<label>Customer ID: </label><br>  -->
	<!-- 		<input type="text" name="customerID" /><br> -->
	<!-- 		<label>Customer Name:</label><br>  -->
	<!-- 		<input type="text" name="customerName" /><br>  -->
	<!-- 		<label>User name:</label><br>  -->
	<!-- 		<input type="text" name="customerUserName" /><br>  -->
	<!-- 		<label>Password:</label><br>  -->
	<!-- 		<input type="text" name="customerPass" /><br>  -->
	<!-- 		<label>Customer Address: </label><br>  -->
	<!-- 		<input type="text" name="customerAddress" /><br>  -->
	<!-- 		<label>Customer Number phone: </label><br>  -->
	<!-- 		<input type="text" name="customerPhone" /><br> -->
	<!-- 		<input type="submit" value="Submit"> -->
	<!-- 	</form> -->

	<div class="register-page">
		<div class="form">
			<form class="form-register" action="RegisterServlet" method="POST"
				onsubmit="return validateForm()" name="myForm">
				<input type="hidden"
					name="customerID" value="00"/><br> <label>Customer Name:</label><br>
				<input type="text" name="customerName" /><br> <label>User
					name:</label><br> <input type="text" name="customerUserName" /><br>
				<label>Password:</label><br> <input type="text"
					name="customerPass" /><br> <label>Customer Address: </label><br>
				<input type="text" name="customerAddress" /><br> <label>Customer
					Number phone: </label><br> <input type="text" name="customerPhone" /><br>
				<button type="submit" value="Submit">Register</button>
			</form>
			<br> <a href="login.jsp"><button>Back</button></a>
		</div>
	</div>
</body>
</html>