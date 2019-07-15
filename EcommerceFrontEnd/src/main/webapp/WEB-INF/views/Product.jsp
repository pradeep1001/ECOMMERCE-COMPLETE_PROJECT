<%@ include file="AdminHome.jsp" %>

<h2 align="centre"> Manage Category</h2>
<form:form action = "insertproduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table align="centre">

		<tr>
				<td>Product Id</td>
				<td><form:input path="productid"/></td>
		 </tr>
		
		 <tr>
				<td>Product Name</td>
				<td><form:input path="productName"/></td>
		 </tr>
		 
		 <tr>
				<td>Product Desc</td>
				<td><form:input path="productDesc"/></td>
		 </tr>
		 
		 <tr>
				<td>Price</td>
				<td><form:input path="price"/></td>
		 </tr>
		 
		 <tr>
				<td>Category</td>
				<td>
				     <form:select    path="categoryId">
    							<form:option value="0" label="---select List--"/>
     							<form:options items="${categoryList}"/>
                     </form:select>
				</td>
		 </tr>
		 
		  <tr>
				<td>supplier</td>
				<td><form:input path="supplierId"/></td>
		 </tr>
		 
		 <tr>
				<td>stock</td>
				<td><form:input path="stock"/></td>
		 </tr>
		 <tr>
				<td> Product Image </td>
		       <td><form:input type="file" path="pimage"/></td>
		 </tr>
		 
		 <tr>
		      <td colspan="2"><input type="submit" value="insert Product"/></td>   
		 </tr>
  
</table>
</form:form>

<table align="center" class="table table-border table-condensed">
        <tr class="danger">
            <td>Product Id</td>
            <td>Product Name </td>
            <td>Price</td>
            <td>stock</td>
            <td>Category</td>
            <td>Supplier</td>
        </tr>
              <c:forEach items="${productList}" var="product">
		          		<tr>
						      <td>${product.productid}</td>
						      <td>${product.productName}</td>
						      <td>${product.price}</td>
						      <td>${product.stock}</td>
						      <td>${product.categoryId}</td>
						      <td>${product.supplierId}</td>
                               <td>						      
						     	<a href="<c:url value="/editProduct/${product.productId}"/>">
						     	<img  src="<c:url value="/resources/images/${product.productid}.jpg"/>" width="25" height="25"/>
						     	</a>
						     	&nbsp;&nbsp;|&nbsp;&nbsp;
						     	<a href="<c:url value="/deleteProduct/${product.productId}"/>">
						     	  <img  src="<c:url value="/resources/images/${product.productid}.jpg"/>" width="25" height="25"/>
						     	</a>
							  </td>
						</tr>
			</c:forEach>
        
</table>
<div class=""col-md-6-col lg-6 col-sm-6 col-xs-12"></div>

</div>
</body>
