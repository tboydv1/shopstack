<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!--font awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--Main style-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style-login.css">


    <title>Shopstack login</title>
  </head>
  <body>
  <br />
            <section class="login">
            <div class = "container">
                <div class="row">
                <div class="col-md-6 col-lg-6 col-sm-4 col-xs-4">
                <div class="hero-image">
                </div>
                </div>



                <div class="col-md-6 col-lg-6 col-sm-4 col-xs-4">

                <img src="${pageContext.request.contextPath}/resources/img/path.png" alt="">
                <img src="${pageContext.request.contextPath}/resources/img/shopstack-logo.png" style="width:150px" alt=""><br />
                <br />

                <h4 class="shift">Sign In</h4>
                <p class="shift-rider">Sign in with social media</p>


                <button type="submit" class="btn btn-danger">
                <i class="fa fa-google" style="color:red" aria-hidden="true"></i>  Login with Google</button><br /><br />
                <!--End Social sign in-->
                
                    
                <p id="email-signin">or login with email address</p>



                <form:form action="${pageContext.request.contextPath}/authenticate" 
							   method="POST" >
							   
							    <!-- Place for messages: error, alert etc ... -->
					<div class="form-group">
			        	<div class="col-xs-15">
			            	<div>
								
							<!-- Check for login error -->

								<c:if test="${param.error != null}">

								<div class="alert alert-danger col-xs-offset-1 col-xs-10">
									Invalid username and password.
								</div>
						
								</c:if>
															
								<!-- Check for logout -->	
							
								<c:if test="${param.logout != null}">
							           
								<div class="alert alert-success col-xs-offset-1 col-xs-10">
									You have been logged out.
								</div>
							
								</c:if>

			            </div>
					        </div>
					    </div>
                    
                    <div class="form-group">
                        <label for="emailAddress">Username</label>
                        <input type="text" class="form-control" id="username" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary">Sign In</button>
                </form:form><br />
                <p>Dont have an account? <a href="${pageContext.request.contextPath}/shop-owner/register">Sign Up</a></p>
                </div>
                  <!--  <button type="submit" class="btn btn-primary">Sign In</button>
                   

                    <p>Dont have an account? <a href="">Sign Up</a></p>
                    </div>-->
                    

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