package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	

	
	@Transactional
    
	public boolean addProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().delete(product); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Product getProduct(int productid) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productid);
		session.close();
		return product;
	}

	public List<Product> listProducts()
	{
		Session session=sessionFactory.openSession();
	List<Product> listProducts=(List<Product>)session.createQuery("from Product").list();
	session.close();
	return listProducts;
	 	
	}

	
	public List<Product> listProductsCategoryWise(int categoryid) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Product where categoryId=: catid");
		query.setParameter("catid",categoryid);
		List<Product> productList=query.list();
		session.close();
		return productList;
	} 
	
	
	


}
