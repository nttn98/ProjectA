<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<%@include file="checkLoginheader.jsp"%>
	<h1>Update Product</h1>
	
	<form action="UpdateProductServlet" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="mode" value="edit">
		<%
		Product editProduct = (Product) request.getAttribute("tempProduct");
		%>
		<label>ID:</label>
		<br> 
		<input type="text" name="productID" value="<%=editProduct.getProductID()%>"/>
		<br> 
		
		<label>Name Of Product:</label>
		<br> 
		<input type="text" name="productName" value="<%=editProduct.getProductName()%>" />
		<br> 
		
		<label>Title Of Product:</label>
		<br> 
		<input type="text" name="productTitle" value="<%=editProduct.getTitle()%>"/><br>
		
		<label>Price</label>
		<br>
		<input type="text" name="productPrice" value="<%=editProduct.getPrice()%>"/><br>
		
		<label>Quantity</label>
		<br>
		<input type="text" name="productQuantity" value="<%=editProduct.getQuantity()%>"/>
		<br>
		<img src="productImage\<%=editProduct.getProductID()%>.jpg" style="width: 5%">
		<br>
		<input type="file" name="fileImg" size="50" />
		
		<button type="submit" value="Submit">Update</button>
		<br>
	</form>
		<a href="ManageProductServlet?mode=view"><button>Back</button></a>
</body>
</html>
