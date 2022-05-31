<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/manageProduct.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="checkLoginheader.jsp"%>
	<%
	ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
	int countProduct = listProduct.size();
	%>
	<h1>
		You have
		<%=countProduct%>
		products.
	</h1>
	<table width="1040px" class="table-showProduct">
		<tr>
			<td width="114px" style="padding-right: 15px;">Product ID</td>
			<td width="114px" style="padding-right: 15px;">Name Of Product</td>
			<td width="114px" style="padding-right: 15px;">Title Of Product</td>
			<td width="114px" style="padding-right: 15px;">Price Of Product</td>
			<td width="114px" style="padding-right: 15px;">Quantity</td>
			<td width="114px" style="padding-right: 15px;">Image</td>
		</tr>
		<%
		for (int i = 0; i < listProduct.size(); i++) {
		%>
		<tr>
			<td><%=listProduct.get(i).getProductID()%></td>
			<td><%=listProduct.get(i).getProductName()%></td>
			<td><%=listProduct.get(i).getTitle()%></td>
			<td><%=listProduct.get(i).getPrice()%></td>
			<td><%=listProduct.get(i).getQuantity()%></td>
			<td><img
				src="productImage\<%=listProduct.get(i).getProductID()%>.jpg"
				style="width: 30%"></td>
			<td><a
				href="ManageProductServlet?mode=delete&id=<%=listProduct.get(i).getProductID()%>"><button>Delete</button></a></td>
			<td><a
				href="UpdateProductServlet?mode=view&id=<%=listProduct.get(i).getProductID()%>"><button>Update
						Product</button></a></td>

		</tr>

		<%
		}
		%>
	</table>
	<a href="viedeli.jsp"><button>Home</button></a>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print("<h1>" + msg + "</h1>");
	}
	%>
	<br>
	<a href="newProduct.jsp"><button>New product</button></a>
	<br>
	<a href="home.jsp"><button>Back</button></a>

</body>

</html>