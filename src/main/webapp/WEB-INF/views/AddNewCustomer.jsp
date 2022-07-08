<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Customer Details</title>
</head>
<body>

<div>
<h1>Add New Customer</h1>
<br/>
<form action="/CRManagement/Customer/new-customer"  method="post">
<input type="hidden" placeholder="Customer Id" name="id" value="1"/>
<br/>
<input type="text" placeholder="Customer First Name" name="f_Name"/>
<br/>
<input type="text" placeholder="Customer last Name" name="l_name"/>
<br/>
<input type="text" placeholder="Customer EmailId" name="email"/>
<br/>
<br/>
<br/>
<br/>
<input type="submit" value="Save" id="saveButton"/>
</form>

</div>
</body>
</html>