<%@ include file="UserHome.jsp" %>

<div class="container">
  <div class="content-wrapper">
    <div class="item-container">
      <div class="container">
         <div class="row">
              <div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
	            <div class="product col-md-3 service-image-left">
			             <centre>
			                 <img id="item-display" src="<c:url value="/resources/images/${product.productid}.jpg"/>" alt=" "></img>
			             </centre>
	            </div>
           </div>
     <form action="<c:url value="/addToCart/${product.productId}"/>" method="get" >
      <div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
	         <div class="product-title">${product.productName}</div>
	         <div class="product-desc">${product.productDesc}</div>
	          <hr>
	          <div class="product-price">INR. ${product.price}</div>
	          <div class="product-stock">In Stock</div>
	           <div class="product-price">Quantity
	               <select name="quantity">
	                  <option value="1">1</option>
	                  <option value="2">2</option>
	                  <option value="3">3</option>
	                  <option value="4">4</option>
	               </select>
	           </div>
	           <hr>
	           <div class="btn-group-cart">
	              <input type="submit" value="Add To Cart" class="btn btn-sucess">
	           </div>
	           <div class="btn-group-wishlist">
	              <button type="button"  class="btn btn-danger">
	                Buy Now
	              </button>
	           </div>
	         </div>
	         </form>
	         </div>     
       <table class="table table-hover">
         <thead>
	           <tr>
	             <th>Product</th>
	             <th>Quantity</th>
		         <th class="text-center">Price</th>
		         <th class="text-center">Total</th>
		         <th> </th>
		       </tr>
        </thead>
        <tbody>
         <c:forEach items="${listCartItems}" var="cartItem">
          <form action="<c:url value="updateCartItem/${cartItem.cartItemId}"/>" method="get">
          <tr>
               <td class="col-sm-8 col-md-6">
               <div class="media">
                     <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
                     <div class="media-body">
                          <h4 class="media-heading"><a href="#">${cartItem.productName}</a></h4>
                          <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
                          <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>     
                    </div>
         </div></td>
         <td class="col-sm-1 col-md-1" style="text-align: center">
         <input type="text" class="form-control" name="quantity" id="quantity" value="${cartItem.quantity}">
         </td>
                       
               <td class="col-sm-1 col-md-1 text-center"><strong>$(cartItem.price)</strong></td>
               <td class="col-sm-1 col-md-1 text-center"><strong>$(cartItem.price*cartItem.quantity)</strong></td>
               <td class="col-sm-1 col-md-1">
		                 <button type="button" class="btn btn-primary">
		                           <span class="glyphicon glyphicon-update"></span> Update
		                 </button>
		                 <a href="<c:url value="/deleteCartItem/$(cartItem.cartItemId)"/>"  class="btn btn-danger">
		                           <span class="glyphicon glyphicon-remove"></span> Remove
		                 </a>
		                 </td>
        </tr>
          </form>
        </c:forEach>
        
        <tr>
		<td>   </td>
        <td>   </td>
        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>${total_Amount}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>${total_Amount /10}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>INR. ${total_Amount + (total_Amount/10)}/-</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="<c:url value="/productDisplay"/>"  class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </a></td>
                        <td>
                        <a href="<c:url value="/confirmOrder"/>"  class="btn btn-default">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </a></td>
                    </tr>
                      
                </tbody>
            </table>
            </div>
            </div>
            </div>