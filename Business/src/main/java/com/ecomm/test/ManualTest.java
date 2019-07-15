package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

public class ManualTest 
{
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
	/*CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		
		Cart cart =new Cart();
		cart.setCartItemId(1);
		cart.setProductid(6);
		cart.setProductName("apple i5");
		cart.setQuantity(34);
		cart.setPrice(24049);
		cart.setStatus("NP");
		cart.setUsername("pradeep Kumar");
		cartDAO.addCartItem(cart);
		*/
		
	}
}