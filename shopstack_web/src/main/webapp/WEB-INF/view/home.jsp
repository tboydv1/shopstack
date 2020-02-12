<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>

<head>
<title>Home Page</title>
</head>

<body>
<h4>Shopstack</h4>
	<h1>Home Page</h1>
	<h2>Welcome to the spring security company home page</h2>
	
	<p>
		Welcome to the luv2code company home page!
		
	</p>
	
	<form:form action="${pageContext.request.contextPath}/user/register" 
			method="GET">
		
		<input type="submit" value="Create Account">
	</form:form>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/login" 
			method="GET">
		
		<input type="submit" value="Sign in">
	</form:form>
	
	<hr>
	
	<!-- Add a logout button 
	<form:form action="${pageContext.request.contextPath}/logout" 
	method="POST">
		
		<input type="submit" value="Logout">
	</form:form>  -->
	
</body>

</html>