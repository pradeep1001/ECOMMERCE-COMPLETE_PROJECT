package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.UserDetail;


public class OrderController 
{
 
	@Autowired
	CartDAO cartDAO;
 
	@Autowired
	UserDetailDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping("/confirmOrder")
	public String showCartPage(Model m)
	{
		String username="pradeep Kumar";
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems",listCartItems);
		m.addAttribute("total_Amount",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("address",userDAO.getUser(username).getAddr());
		
		return "OrderConfirm";
		
	}
	
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr")String address,Model m )
	{
		String username="pradeep Kumar";
	    UserDetail user=userDAO.getUser(username);	
	    user.setAddr(address);
	    userDAO.updateUser(user);

        List<Cart> listCartItems=cartDAO.listCartItems(username);
        m.addAttribute("listCartItems",listCartItems);
    	m.addAttribute("total_Amount",this.calcGrandTotalPrice(listCartItems));
		
		
		return "OrderConfirm";
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
	
	@RequestMapping(value="/payment")
	public String showPaymentPage(Model m )
	{
		String username="pradeep Kumar";
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("total_Amount",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("address",userDAO.getUser(username).getAddr());
		m.addAttribute("listCartItems",listCartItems);
		
		return "Payment";
	}
	
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String showReceiptPage(@RequestParam("pmode")String pmode,Model m )
	{
		String username="pradeep Kumar";
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		int totalAmount;
		totalAmount=this.calcGrandTotalPrice(listCartItems);
		 
		m.addAttribute("total_Amount",this.calcGrandTotalPrice(listCartItems));
		m.addAttribute("address",userDAO.getUser(username).getAddr());
		m.addAttribute("listCartItems",listCartItems);
		
		OrderDetail  orderdetail= new OrderDetail();
		orderdetail.setTotalShippingAmount(totalAmount);
		orderdetail.setPmode(pmode);
		orderdetail.setUserName(username);
		orderdetail.setOrderDate(new java.util.Date());
		
		orderDAO.payment(orderdetail);
		orderDAO.updateCartItemStatus(username,orderdetail.getOrderId());
		
		return "Receipt";
	}
	
}
