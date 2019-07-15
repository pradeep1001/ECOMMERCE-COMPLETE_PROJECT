package com.ecomm.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

@Controller
public class UserController 
{
	
	@Autowired
	UserDetailDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerUser(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("customerName")String customerName,@RequestParam("email")String email,@RequestParam("addr")String addr)
	{
	
		UserDetail user=new UserDetail();
		
		
		user.setUserName(username);
		user.setPassword(password);
		user.setCustomerName(customerName);
		user.setEmail(email);
		user.setAddr(addr);
		user.setEnabled(true);
		user.setRole("USER");
		
		userDAO.registerUser(user);
	    
		return "Register";
	}
	
	
	@RequestMapping(value="/perform_logout")
	public String loggingOut( HttpSession session )
	{
		session.invalidate();
		return "Login";
	}

	@RequestMapping(value="/login_success")
	public String loginCheck( HttpSession session ,Model m)
	{
		List<Product> productList=productDAO.listProducts();
	      m.addAttribute("productList",productList);
	      
	      List<Category> categoryList=categoryDAO.listCategories();
	      m.addAttribute("categoryList",categoryList);   
	      
	      String page="";
			boolean loggedIn=false;
			
			SecurityContext sContext=SecurityContextHolder.getContext();
			Authentication authentication=sContext.getAuthentication();	
			
			String username=authentication.getName();
			Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
			
			//List<Category> listCategories=categoryDAO.listCategories();
			
			for(GrantedAuthority role:roles)
			{
				session.setAttribute("role", role.getAuthority());
				
				if(role.getAuthority().equals("ADMIN"))
				{
					loggedIn=true;
					page="AdminHome";
					session.setAttribute("loggedIn", loggedIn);
					session.setAttribute("username", username);
				}
				else
				{
					loggedIn=true;
					page="UserHome";
					session.setAttribute("loggedIn", loggedIn);
					session.setAttribute("username", username);
				}
			}
			
		return page;
	
	}
	
	@RequestMapping("home")
	public String home(Model m)
	{
		return "home";
	}
	
	@RequestMapping("homeus")
	public String home1(Model m)
	{
		return "homeus";
	}	
	
}
