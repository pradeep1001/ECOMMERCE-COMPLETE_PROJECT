<%@include file="Header.jsp"%>

<h2 align="centre">Product Gallery</h2>

<div class="container">
   <div class="row text-centre gtext-lg-left">
   
     <c:forEach items="${productList}" var="product">
		 <div class="col-md-3 4 col-sm-4 col-xs-1">
			   <a href="<c:url value="/totalProductDisplay/$/${product.productid}"/>" class="d-b;lock mb-4 h-100"></a>
		       <img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productid}.jpg"/>" width="100" height="100" />  	    
			   <p>Price :${product.price}</p>
			   <p>Stock :${product.stock}</p>
			   </a>
		  </div>          		
	 </c:forEach>
   
   </div>

</div>