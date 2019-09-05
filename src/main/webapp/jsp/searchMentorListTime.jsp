<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.*,com.examples.mentor.model.Mentor" pageEncoding="ISO-8859-1"%>
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
<form:form method="POST" action="/getMentorsByTime" modelAttribute="mentor">
   
        <h3 class="createaccount">Mentor List</h3><br>
        <%
        List mentorList=(List)request.getAttribute("mentorList");
		%>
		
		<table class="table table-striped">
		 <tr class="section">
		 <th >Mentor Id</th>
            <th>Mentor Name</th>
             <th >Year of Experience</th>
            <th >Number of Training Completed</th>
            <th >Linked in URL</th>
             <th >Contact Number</th>
              <th>Email</th>
              <th >Technology</th> 
           <th></th>
    </tr>

        <% for(int i=0;i<mentorList.size();i++){
	Mentor mentor=(Mentor)mentorList.get(i);
	%>
	
	 <tr>
            <td ><%= mentor.getMentorId() %></td>
            <td><%= mentor.getMentorName()%></td>
             <td ><%= mentor.getYearOfExperience() %></td>
            <td ><%= mentor.getNumberOfTrainingCompleted()%></td>
            <td><%= mentor.getLinkedInURL()%></td>
             <td><%= mentor.getMobileNumber() %></td>
             <td><%= mentor.getEmail() %></td>
               <td><%= mentor.getTechnology()%></td> 
          <%-- <td id="td2 ptext"> <a href="updateCompany?companyCode=<%= c.getCompanyCode()%>" ><button class="edit">Edit</button></a> 
          <a href="deleteCompany?companyCode=<%= c.getCompanyCode()%>" ><button class="edit">Delete</button></a></td> --%>
          <td></td>
        </tr>
        <% }%>
     </table>
    </div>
   </form:form>
</div>
</body>
</html>  