package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;

import com.ecomm.model.Cart;


public class CartDAOUnitTestCases {
 static CartDAO cartDAO;
 
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

    @Ignore
	@Test
	public void addCartItemTest()
	{
		Cart cart=new Cart();
		cart.setCartItemId(3);
		cart.setProductid(9);
		cart.setProductName("OnePlus 6T");
		cart.setQuantity(18);
		cart.setPrice(41999);
		cart.setStatus("NP");
		cart.setUsername("sunil");
		
		assertTrue("Problem in Cart Insertion",cartDAO.addCartItem(cart));
	}
	
	
	@Ignore
	@Test
	public void updateCartTest()
	{
		Cart cart=cartDAO.getCartItem(1);
		cart.setQuantity(11);
		
		assertTrue("Problem in Updation",cartDAO.updateCartItem(cart));
	}
   
	
	@Test
	public void listCartItemsTest()
	{
		List<Cart> listCartItems = cartDAO.listCartItems("krishna murthy");
		
		assertTrue("Problem in retrieving the Cart Items",listCartItems.size()>0);
		for(Cart cartItem:listCartItems)
		{
			System.out.print(cartItem.getProductid()+"::");
			System.out.print(cartItem.getProductName()+"::");
			System.out.print(cartItem.getQuantity()+"::");
			System.out.print(cartItem.getUsername()+"::");
		}
	}
	
}
