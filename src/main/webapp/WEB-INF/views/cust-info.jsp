<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.org.crm.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
<div>
	<h1> Customer RelationShip Management</h1>
	

		<div>
		<a href="/CRManagement/Customer/add-new-customer">Add Customer</a>
		<br/>
		<br/>
		<%
		List<Customer> custs= (List<Customer>) request.getAttribute("custInfo");
		out.println("<table border=1> <tr><th>First Name</th><th>Last Name</th><th>email</th><th>Delete/Update</th></tr>");
		if (custs!=null) {
		for (Customer cust: custs)
			out.println("<tr><td>"+cust.getF_Name()+"</td><td>"+cust.getL_name()+"</td><td>"+cust.getEmail()+"</td><td><a href='/CRManagement/Customer/delete-customer?id="+cust.getId()+"'>Delete/</a><a href='/CRManagement/Customer/update-customer?id="+cust.getId()+"'>Update</a></td></tr>");
		}
		%>
		</div>

</div>
</body>
</html>