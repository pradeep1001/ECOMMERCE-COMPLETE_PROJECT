package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.OrderDAO;
import com.ecomm.model.OrderDetail;

public class OrderDetailDAOUnitTestCases
{
	static OrderDAO orderDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		orderDAO=(OrderDAO)context.getBean("orderDAO");
	}

	@Test
	public void testPayment()
	{
	   OrderDetail orderdetail = new OrderDetail();
	   orderdetail.setTotalShippingAmount(2992);
	   orderdetail.setPmode("cc");
	   orderdetail.setUserName("pradeep kumar");
	   orderdetail.setOrderDate(new java.util.Date());
	   
	   orderDAO.payment(orderdetail);
	   
	   assertTrue("Problem in updating the Cart ",orderDAO.updateCartItemStatus("pradeep Kumar",orderdetail.getOrderId()) );
	}
	
}
