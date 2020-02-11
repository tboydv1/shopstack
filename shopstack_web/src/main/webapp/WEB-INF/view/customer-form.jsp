<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>

<title>ShopStack Customer Registration Form</title>

<style >
	.error {color: blue}
</style>

</head>
<body>


	<form:form action=" ${pageContext.request.contextPath}/customer/process" modelAttribute="customer" method="GET">
		
		
		Customer Name (*): <form:input path="name"/>
		<form:errors path="name" cssClass="error" />
		
		<br><br>
		
		
		Email (*): <form:input path="email"/>
		<form:errors path="email" cssClass="error" />
		
		<br><br>
		
		Organization Name: <form:input path="organizationName"/>
		
		<form:errors path="organizationName" cssClass="error" />
		
		<br><br>
		
		Contact Number (*): <form:input path="contactNumber"/>
		<form:errors path="contactNumber" cssClass="error" />
		<br><br>
		
		<input type="submit" value="Submit"/>
	
	</form:form>
		
	
</body>

</html>