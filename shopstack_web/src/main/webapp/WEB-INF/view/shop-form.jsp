<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
	<title>Shop Form</title>


</head>
	
	<body>
		
		<form:form action="process" modelAttribute="shop" method="POST" >
			
			<br><br>
			Shopname:
			<form:input type="text" path="shopName" placeholder="Enter shop name" />
			
			<form:select path="category" >
				<form:option value="Retail" label="Retail" />
				<form:option value="Finance" label="Finance" />
				<form:option value="Services" label="Services" />
				<form:option value="Manufacturing" label="Manufacturing" />
				<form:option value="Wholesale" label="Wholesale" />
			</form:select>
			
			<br><br>
			Address:
			<form:input type="text" path="address" placeholder="Enter shop address" />
			
			<br><br>
			Email:
			<form:input type="email" path="shopEmail" placeholder="Enter shop email" />
			
			<br><br>
			Website:
			<form:input type="text" path="website" placeholder="Enter shop website" />
			
			
			
		
		</form:form>
	
	
	
	
	
	
	
	</body>


</html>