
<%@include file="AdminHome.jsp"%>


<h2 align="centre">Update Category</h2>

<form action="<c:url value="/UpdateCategory"/>" method="post">
<table align="centre">

  <tr>
		<td>Category Id</td>
		<td><input type="text" name="categoryId"  readonly value="${category.categoryId}"/></td>
  </tr>
  <tr>
		<td>Category Name</td>
		<td><input type="text" name="categoryName"  value="${category.categoryName}"/></td>
  </tr>
 
 <tr>
		<td>Category Desc</td>
		<td><input type="text" name="categoryDesc" value="${category.categoryDesc}"/></td>
 </tr>
 
 <tr>
      <td colspan="2"><input type="submit" value="Update Category"/></td>   
 </tr>
  
</table>
</form>
