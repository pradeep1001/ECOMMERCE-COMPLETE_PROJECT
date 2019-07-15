package com.ecomm.test;
import static org.junit.Assert.*;
import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;
import com.ecomm.dao.SupplierDAO;

public class SupplierDAOUnitTestCases 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setId(10);
		supplier.setSupplierName("One Plus Company");
		supplier.setSupplierDesc("ceo of one plus is : pete Lau  and is present since 2013 ");
		assertTrue("Problem in adding the Category ",supplierDAO.addSupplier(supplier));
	}
	
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Category",supplierDAO.getSupplier(10));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(10);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}
    
	 @Ignore
     @Test
	public void updateCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(10);
		supplier.setSupplierName("One Plus Company Inc");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
    
	
	@Test
	public void listCategoriesTest()
	{
		List<Supplier> listSuppliers=supplierDAO.getSupplier();
		assertNotNull("No Categories",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierDesc());
		}
	}
	
}

