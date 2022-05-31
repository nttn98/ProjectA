<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product Page</title>
<link rel="stylesheet" href="css/product.css">
</head>
<script language="javascript">
	function validateForm() {
		let productID = document.forms["myForm"]["productID"].value;
		if (productID == "") {
			alert("ID must be filled out");
			return false;
		}
		let productName = document.forms["myForm"]["productName"].value;
		if (productName == "") {
			alert("Name must be filled out");
			return false;
		}

// 		if (!productName
// 				.match("^[A-Za-z]{1,20}, [A-Za-z]{1,20}, [A-Za-z]{1,20}")) {
// 			alert("Name must be text");
// 			return false;
// 		} 
		
		let productPrice = document.forms["myForm"]["productPrice"].value;
		if (productPrice == "") {
			alert("Price must be filled out");
			return false;
		}
		let productQuantity = document.forms["myForm"]["productQuantity"].value;
		if (productQuantity == "") {
			alert("Quantity must be filled out");
			return false;
		}
// 		try {
// 			Integer.parseInt(productQuantity);
// 		} catch (e) {
// 			alert("Quantity must be number");
// 			return false;
// 		}
		let fileImg = document.forms["myForm"]["fileImg"].value;
		if (fileImg == "") {
			alert("You should choose an image");
			return false;
		}
	}
</script>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print("<h1>" + msg + "</h1>");
	}
	%>
	<!-- 	<form action="AddProductServlet" method="GET"> -->
	<!--         <label >Product ID:</label><br> -->
	<!--         <input type="text" name="productID"/><br> -->
	<!-- 	    <label >Name Of Product:</label><br> -->
	<!--         <input type="text" name="productName"/><br> -->
	<!-- 		<label >Title Of Product:</label><br> -->
	<!-- 	    <input type="text" name="productTitle"/><br> -->
	<!--         <label >Price</label><br>            -->
	<!--         <input type="text" name="productPrice"/><br> -->
	<!-- 		<label >Quantity</label><br> -->
	<!-- 		<input type="text" name="productQuantity"/><br> -->
	<!--        	<input type="submit" value="Submit"> -->
	<!-- 	</form> -->

	<div class="newProduct-page">
		<div class="form">
			<form class="form-newProduct" action="AddProductServlet"
				method="POST" enctype="multipart/form-data"
				onsubmit="return validateForm()" name="myForm">
				<label>Product ID:</label><br> <input type="text"
					name="productID" /><br> <label>Name Of Product:</label><br>
				<input type="text" name="productName" /><br> <label>Brand
					Of Product:</label><br> <input type="text" name="productTitle" /><br>
				<label>Price</label><br> <input type="text" name="productPrice" /><br>
				<label>Quantity</label><br> <input type="text"
					name="productQuantity" /><br> <label>Image</label><br> <input
					type="file" name="fileImg" size="50" />
				<button type="submit" value="Submit">Add</button>
			</form>
			<br> <a href="ManageProductServlet?mode=view"><button>Back</button></a>
		</div>
	</div>
</body>
</html>