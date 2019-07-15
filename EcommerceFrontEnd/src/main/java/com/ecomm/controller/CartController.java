package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController 
{
		
	
	@Autowired 
	ProductDAO productDAO;
	
	@Autowired 
	CartDAO cartDAO;
	
	
	@RequestMapping("/addToCart/{productid}")
	public String addCartItem(@PathVariable("productid")int productid,@RequestParam("quantity")int quantity, Model m)
		{
			Cart cart=new Cart();
			Product product=productDAO.getProduct(productid);
			
			String username="pradeep Kumar";
			
			cart.setProductid(productid);
			cart.setProductName(product.getProductName());
			cart.setQuantity(quantity);
			cart.setStatus("NP");
			cart.setUsername(username);
		
			cart.setPrice(product.getPrice());
		
			cartDAO.addCartItem(cart);
			List<Cart> listCartItems=cartDAO.listCartItems(username);
			m.addAttribute("listCartItems",listCartItems);
			

			return "Cart";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String  deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m)
	{
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		 String username="pradeep Kumar";
		 
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("listCartItem",listCartItems);
		
		
		return "cart";
	}
	

	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m)
	{
		
		Cart cart=cartDAO.getCartItem(cartItemId);
		cart.setQuantity(quantity);
		cartDAO.updateCartItem(cart);
		
		String username="pradeep Kumar";
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		
		m.addAttribute("listCartItem",listCartItems);
		
		
		return "Cart";
		
	}
	
	public int calcGrandTotalPrice(List<Cart> listCartItems)
	{
		int total_Amount=0;
		int count=0;
		while(count<listCartItems.size())
		{
			Cart cartItem=listCartItems.get(count);
			total_Amount=total_Amount+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
			
		}
		System.out.print(total_Amount);
		return total_Amount;
	}
	
	@RequestMapping(value="/OrderConfirm")
	public String show(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("listCartItem",listCartItems);
		m.addAttribute("grandtotal",this.calcGrandTotalPrice(listCartItems));
		
		return "OrderConfirm";
	}
}
