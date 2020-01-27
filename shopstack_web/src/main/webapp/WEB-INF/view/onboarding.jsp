<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
	<head>
		
		<title>Business Owner Registration</title>
		
		<!-- Bootstrap files reference -->
			<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
			<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
			<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<!------ Include the above in your HEAD tag ---------->
			
			<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
			
			<style type="text/css">
				.error{
					color:red
				}
			
			</style>
	</head>

<body>
	<div class="container">
	
<!--  <br>  <p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
<hr> -->


<div class="card bg-light">

<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p class="text-center">Get started with your free account</p>
	
	
	<!-- Login extensions -->
	
<!-- 	<p>
		<a href="" class="btn btn-block btn-twitter"> <i class="fab fa-twitter"></i>   Login via Twitter</a>
		<a href="" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i>   Login via facebook</a>
	</p> -->
			
			
		<!-- Registration form start -->
				
	<form:form action = "shop-owner" modelAttribute = "shopOwner" method = "POST">
			
			<div class="form-group input-group">
			
				 <div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
				 </div>
				 
		        <form:input path="firstName" class="form-control" placeholder="First name" type="text" />
		        
		    
		        
		    </div> <!-- form-group// -->
		    
		    <div class="form-group input-group">
		    
				<div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
				 </div>
				 
		        <form:input path="lastName" class="form-control" placeholder="Last name" type="text"/>
		       
		        
		    </div> <!-- form-group// -->
		    
		    <div class="form-group input-group">
		    
		    	<div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
				 </div>
				 
		        <form:input path="email" class="form-control" placeholder="Email address" type="email" />
		        <form:errors path="email" cssClass="error" />
		        
		    </div> <!-- form-group// -->
		    
		    
		    <div class="form-group input-group">
		    	<div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
				</div>
				
		    	<form:input path="contactNumber" class="form-control" placeholder="Phone number" type="text" />
		    </div> <!-- form-group// -->
		    
		    
		      <div class="form-group input-group">
				<div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
				 </div>
		        <form:input path="userName" class="form-control" placeholder="Username" type="text"/>
		    </div> 
	
		    
		    
		   
			
		    <div class="form-group input-group">
		    	<div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
				</div>
		        <form:input path="password" class="form-control" placeholder="Create password" type="password" />
		    </div> <!-- form-group// -->
		    
		    
		    
		    <!--  -->
		   <!-- <div class="form-group input-group">
		    	<div class="input-group-prepend">
				    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
				</div>
		        <class="form-control" placeholder="Repeat password" type="password">
		    </div>  form-group// -->   
		                                       
		    <div class="form-group">
		        <input type="submit" value="Create Account" class="btn btn-primary btn-block" />  
		    </div> <!-- form-group// -->  
		        
	 	   <p class="text-center">Have an account? <a href="${pageContext.request.contextPath}/login">Log In</a> </p>                                                                 
	</form:form>
				<!-- Registration form end -->
				
		<!-- </div>
			
			<div class="col-md-4">
			
			</div> -->	
		
	</article>
	</div>
	
	</div>

</body>


</html>