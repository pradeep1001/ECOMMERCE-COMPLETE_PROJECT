<%@include file="AdminHome.jsp"%>
<h2 align="centre">Manage category </h2>
<form:form  action="UpdateProduct" modelattribute="product" method="post">
<table align="centre">

  <tr>
		<td>Product Name</td>
		<td><form:input path="productName"/><td>  
  </tr>
  <tr>
		<td>Product Desc</td>
		<td><form:input path="productDesc"/><td>  
  </tr>
  <tr>
		<td>Price</td>
		<td><form:input path="price"/><td>  
  </tr>
  <tr>
		<td>Category</td>
		<td><form:input path="categoryId"/><td>  
  </tr>
  <tr>
		<td>Supplier</td>
		<td><form:input path="supplierId"/><td>  
  </tr>
  <tr>
		<td>stock</td>
		<td><form:input path="stock"/><td>  
  </tr>
 
 <tr>
      <td colspan="2"><input type="submit" value="Update Product"/></td>   
 </tr>
  
</table>
</form:form>
