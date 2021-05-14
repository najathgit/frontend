<%@page import="model.Hospital"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>User Management</h1>
				<form id="formUser" name="formUser">
					User ID: 
					<input id="userID" name="userID" type="text"
						class="form-control form-control-sm"> <br> 
						
					User First Name:
					<input id="fName" name="fName" type="text"
						class="form-control form-control-sm"> <br>
						
					User Last Name: 
					 <input id="lName" name="lName" type="text"
						class="form-control form-control-sm"> <br> 
					
						
					User Date Of Birth: 
					 <input id="db" name="db" type="text"
						class="form-control form-control-sm"> <br> 
					
							
					User Address: 
					 <input id="address" name="address" type="text"
						class="form-control form-control-sm"> <br> 
						
							
					User Telephone Number: 
					 <input id="Tnumber" name="Tnumber" type="text"
						class="form-control form-control-sm"> <br> 
						
							
					User User Name: 
					 <input id="UName" name="UName" type="text"
						class="form-control form-control-sm"> <br> 
						
							
					User Password: 
					 <input id="pass" name="pass" type="text"
						class="form-control form-control-sm"> <br> 
						
							
					User Email: 
					 <input id="Email" name="Email" type="text"
						class="form-control form-control-sm"> <br> 
						
						<input id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidhosNOSave" name="hidhosNOSave" value="">
						
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divHospitalGrid">
					<%
						User userObj = new User();
					    out.print(userObj.readUser());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>