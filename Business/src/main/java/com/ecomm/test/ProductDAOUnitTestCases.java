package com.ecomm.test;

import static org.junit.Assert.*;
import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.ProductDAOImpl;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

public class ProductDAOUnitTestCases {
	static ProductDAO productDAO;

	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Ignore
	@Test
	public void addProductUnitTest()
	{
		Product product = new Product();
		product.setProductid(10);
		product.setProductName("OnePlus 7T");
		product.setProductDesc(" mobile with 4G connectivity and 20MP Back camera, 16MP Front Camera");
		product.setPrice(42999);
		product.setStock(12);
		product.setCategoryId(4);
		product.setSupplierId(10);
		assertTrue("Problem in adding the Category ",productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(10);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
    
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(8);
		product.setProductName(" xiaomi A2");
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
    @Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in getting 	Product",productDAO.getProduct(6));
	}
	
	
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertNotNull("No Categories",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductid()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductDesc());
		}
	}
    
	
}
