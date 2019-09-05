<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mentor on Demand</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="/Style/style.css">
</head>
<body>
<div class="container">
<form:form method="GET" action="/loginVerification" modelAttribute="login" class="loginform">
 
<h2 class="createaccount" >Login</h2>
<br><br>
   <div class="row">
            <div class="form-group col-md-12">
   
               <div class="col-md-6 col-md-offset-3">
                    <form:input type="email" path="email" id="email" class="form-control input-sm" placeholder="Email" />
                    <div class="has-error">
                        <form:errors path="email" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        
	<div class="row">
            <div class="form-group col-md-12">
               <div class="col-md-6 col-md-offset-3">
                    <form:input type="password" path="password" id="password" class="form-control input-sm" placeholder="Password" />
                    <div class="has-error">
                        <form:errors path="password" class="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        


     <div class="row">
   
            <div class="col-md-2 col-md-offset-2">
            <input type="submit" value="Signup" class="save">
   		   </div>
			<div class="col-md-2 col-md-offset-1">
   			 <input type="reset"  value="Clear" class="save">
    		</div>
    </div>
   
       
</form:form>
 <p class="dangermessage"> <span>${message}</span></p>
</div>
</body>
</html>