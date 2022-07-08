<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.org.crm.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Customer RelationShip Management</h1>
<br/>
<br/>
<br/>
<h5>Update the Customer details</h5>
<br/>
<br/>
<%
   Customer customerDetail=(Customer)request.getAttribute("custDetail");
   out.println("<form action='/CRManagement/Customer/updated-customer'  method='post'>");
   out.println("<input type='hidden' placeholder='Customer Id' name='id' value='"+customerDetail.getId()+"'/>");
   out.println("<br/>");
   out.println("<input type='text' placeholder='Customer First Name' name='f_Name' value='"+customerDetail.getF_Name()+"'/>");
   out.println("<br/>");
   out.println("<input type='text' placeholder='Customer last Name' name='l_name' value='"+customerDetail.getL_name()+"'/>");
   out.println("<br/>");
   out.println("<input type='text' placeholder='Customer EmailId' name='email' value='"+customerDetail.getEmail()+"'/>");
   out.println("<br/>");
   out.println("<br/>");
   out.println("<br/>");
   out.println("<br/>");
   out.println("<input type='submit' value='Update' id='saveButton'/>");
   out.println("</form>");

%>

</body>
</html>