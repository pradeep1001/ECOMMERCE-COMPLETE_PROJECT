package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Cart;

public interface CartDAO 
{
	public boolean addCartItem(Cart cart);
	public boolean deleteCartItem(Cart cart);
	public boolean updateCartItem(Cart cart);
	public List<Cart>listCartItems(String username);
	public Cart getCartItem(int cartItemId);
	
	
}
