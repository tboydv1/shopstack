
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	Congratulations -- You successfully registered!!
	
	<br>
	
	<form:form action="${pageContext.request.contextPath}/login" 
			method="GET">
		
		<input type="submit" value="Sign in">
	</form:form>
	
	
</body>
</html>