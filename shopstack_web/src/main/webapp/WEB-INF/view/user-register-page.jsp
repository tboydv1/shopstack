<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!--Main style-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />


    <title>Shopstack Registration</title>
  </head>
  <body>
  <br />
            <section class="register">
            <div class = "container">
                <div class="row">
                <div class="col-md-6 col-lg-6 col-sm-4 col-xs-4">
                <div class="hero-image">
                    <h5 id="hero-text">Track Your sales, Delivery, and Expense
                        All on The <b>SHOPSTACK</b> WEB PLATFORM AND EXPERIENCE 
                        DOUBLE COMFORT</h5>
                </div>
                </div>



                <div class="col-md-6 col-lg-6 col-sm-4 col-xs-4">

                
                <img src="${pageContext.request.contextPath}/resources/img/shopstack-logo.png" style="width:150px" alt=""><br /><br />
                <br />

                <h4 class="shift">Create new account</h4>
                <p class="shift-rider">Use your work email to create new account... it's free.</p>

                <form:form action ="${pageContext.request.contextPath}/user/process" modelAttribute="user"  method = "GET">
                    
                       <div class="form-row">
                        <div class="form-group col-md-6">
                        <label for="InputFirstname">Firstname</label>
						 
				        		<form:input  type="text" path="firstName" class="form-control" placeholder="First name"/>
			        	 
	        			</div>
	        			
                        <div class="form-group col-md-6">
                        <label for="inputLastname">Lastname</label>
              
	        			<form:input type="text"  class="form-control" path="lastName" placeholder="Last name" />
                       
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail">Email Address</label>
                        
                        
				        <form:input  type="email" path="email" class="form-control" placeholder="Email address" />
				       
                    </div>
                    
                       
                    <div class="form-group">
                        <label for="inputPhoneNumber">Phone number</label>
                        
                        
				        <form:input  type="text" path= "phoneNumber" class="form-control" placeholder="phone Number" />
				       
                    </div>
                    
                    
                     <div class="form-group">
                        <label for="inputPhoneNumber">Password</label>
                        
                        
				        <form:input  type="password" path= "password" class="form-control" placeholder="Password" />
				       
                    </div>
                   
                       
                    <div class="form-group">
                        <div class="form-check row">
                        	<div class="col-md">
	                        <input class="form-check-input" type="checkbox" id="gridCheck">
	                        <label class="form-check-label" for="gridCheck">
	                            I have read the <a href="">Terms and Conditions.</a>
	                        </label>
	                        </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign up Now</button>
                    
                    </form:form>
                    
                   <!-- <br />  -->

                     
                     </div>
                    
                    </div>
					
					</div>  
                           
                    
    </section>


<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>