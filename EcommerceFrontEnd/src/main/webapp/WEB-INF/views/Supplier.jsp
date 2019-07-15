<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp"%>


<h2 align="center">Supplier Page</h2>

<form action="<c:url value="/InsertSupplier"/>" method="post">

<table align="center">
	<tr>
		<td colspan="2">Supplier Info</td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="supplierName"/></td>
	</tr>
	<tr>
		<td>Supplier Desc</td>
		<td><input type="text" name="supplierDesc"/></td>
	</tr>
	<tr>
		<td colspan="2"><center><input type="submit" value="Save Supplier"/></center></td>
	</tr>
	
</table>

<table align="center" border="1">
	<tr>
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operation </td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr>
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierDesc}</td>
		<td>
			<a href="<c:url value="/updateSupplier/${supplier.supplierId}"/>">Edit</a>
			<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

</form>
