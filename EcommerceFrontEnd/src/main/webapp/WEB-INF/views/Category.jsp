<%@include file="AdminHome.jsp"%>

<h2 align="centre">Manage Category</h2>

<form action="<c:url value="/insertCategory"/>" method="post">
<table align="centre">

		 <tr>
				<td>Category Id</td>
				<td><input type="text" name="categoryId"/></td>
		 </tr>
		
		 <tr>
				<td>Category Name</td>
				<td><input type="text" name="categoryName"/></td>
		 </tr>
		 
		 <tr>
				<td>Category Desc</td>
				<td><input type="text" name="categoryDesc"/></td>
		 </tr>
		 
		 <tr>
		      <td colspan="2"><input type="submit" value="insert Category"/></td>   
		 </tr>
  
</table>
</form>


<table align="center">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>operation</td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
     		<td>${category.categoryId}</td>
	    	<td>${category.categoryName}</td>
		    <td>${category.categoryDesc}</td>
		    <td><a href="<c:url value ="/deleteCategory/${category.categoryId}"/>">Delete</a>
		        <a href="<c:url value ="/editCategory/${category.categoryId}"/>">Edit</a>
		    </td>   
	</tr>
	</c:forEach>
</table>