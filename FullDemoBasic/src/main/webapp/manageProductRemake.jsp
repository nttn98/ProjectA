<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<title>Manage Product Page</title>
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
	ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
	int countProduct = listProduct.size();
	%>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">Manage Product</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-center">
						You have
						<%=countProduct%>
						products.
					</h3>
					<div>
						<table class="table">
							<thead class="thead-primary">
								<tr>
									<th>Images</th>
									<th>ID</th>
									<th>Name Of Product</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Quantity</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < listProduct.size(); i++) {
								%>
								<tr class="alert" role="alert">
									<td><img
										src="productImage\<%=listProduct.get(i).getProductID()%>.jpg"
										style="width: 30%"></td>
									<td>
										<div class="productID">
											<span><%=listProduct.get(i).getProductID()%></span>
										</div>
									</td>
									<td>
										<div class="productName">
											<span><%=listProduct.get(i).getProductName()%></span>
										</div>
									</td>
									<td>
										<div class="productTitle">
											<span><%=listProduct.get(i).getTitle()%></span>
										</div>
									</td>
									<td><%=listProduct.get(i).getPrice()%></td>
									<td class="quantity"><%=listProduct.get(i).getQuantity()%>
									</td>
									<td><a
										href="ManageProductServlet?mode=delete&id=<%=listProduct.get(i).getProductID()%>"><button
												class="btn-product">Delete</button></a></td>
									<td><a
										href="UpdateProductServlet?mode=view&id=<%=listProduct.get(i).getProductID()%>"><button
												class="btn-product">Update</button></a></td>

								</tr>
							</tbody>
							<%
							}
							%>
						</table>
<%-- 						<% --%>
<!-- // 						String msg = (String) request.getAttribute("msg"); -->
<!-- // 						if (msg != null) { -->
<!-- // 							out.print(msg); -->
<!-- // 						} -->
<%-- 						%> --%>
						<a href="LoginServlet?mode=homeOnly"><button class="btn-product">Home</button></a>
						<br>
						<br> <a href="newProduct.jsp"><button class="btn-product">New
								product</button></a> <br> <br> <a href="home.jsp"><button
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

