
<%@page import="configPkg.ConfigInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>Login Page</title>
</head>
<body>
	<!-- 	<h1>Login</h1> -->
	<!-- 	<form action="LoginServlet" method="POST"> -->
	<!-- 		<input type="hidden" name="mode" value="login"> <label>User -->
	<!-- 			Name</label><br> <input type="text" name="userName" /><br> <label>Password:</label><br> -->
	<!-- 		<input type="text" name="userPassword" /><br> <input -->
	<!-- 			type="submit" value="Submit"> -->
	<!-- 	</form> -->
	<!-- 	<a href="register.jsp">Register</a> -->
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="LoginServlet" method="POST">
				<input type="hidden" name="mode" value="login"> <label>User
					Name</label> <br> <input type="text" placeholder="username"
					name="userName" /> <br> <label>Password:</label> <br> <input
					type="text" placeholder="password" name="userPassword" /> <br>

				<button type="submit" value="Submit">Login</button>
				<p class="message">
					Not have an account? <a href="register.jsp">Create an account</a>
				</p>
			</form>
			<br> <a href="LoginServlet?mode=homeOnly"><button>Home</button></a>
		</div>
	</div>

</body>

</html>
