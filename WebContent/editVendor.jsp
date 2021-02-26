<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vendor</title>
</head>
<body>

<form action = "editVendorServlet" method="post">
Vendor Name: <input type ="text" name = "vendorName" value="${itemToEdit.vendorName}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Vendor">
</form>

</body>
</html>