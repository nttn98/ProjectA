<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/product.css">
<title>Edit Product Page</title>
</head>
<body>
	<%@include file="checkLoginheader.jsp"%>
	<h1 style="text-align: center;">Update Product</h1>

	<div class="updateProduct-page">
		<div class="form">
			<form action="UpdateProductServlet" method="POST"
				enctype="multipart/form-data">
				<input type="hidden" name="mode" value="edit">
				<%
				Product editProduct = (Product) request.getAttribute("tempProduct");
				%>
				<label>ID:</label><br> <input type="text" name="productID"
					value="<%=editProduct.getProductID()%>" readonly="readonly" /> <label>Name Of
					Product:</label> <br> <input type="text" name="productName"
					value="<%=editProduct.getProductName()%>" /> <label>Title
					Of Product:</label><br> <input type="text" name="productTitle"
					value="<%=editProduct.getTitle()%>" /> <label>Price</label><br>
				<input type="text" name="productPrice"
					value="<%=editProduct.getPrice()%>" /> <label>Quantity</label><br>
				<input type="text" name="productQuantity"
					value="<%=editProduct.getQuantity()%>" /> <img
					src="productImage\<%=editProduct.getProductID()%>.jpg"
					style="width: 5%"> <input type="file" name="fileImg"
					size="50" />
				<button type="submit" value="Submit">Update</button>
			</form>
			<br> <a href="ManageProductServlet?mode=view"><button>Back</button></a>
		</div>
	</div>
</body>
</html>