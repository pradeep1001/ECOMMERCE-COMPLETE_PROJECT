package com.ecomm.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements  SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;

	
 
	
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}	
	}
	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
		
	}

	public Supplier getSupplier(int supplierId)
	{
	
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}
	public List<Supplier> listSupplier() 
	{
		Session session=sessionFactory.openSession();
		List<Supplier> listCategories=(List<Supplier>)session.createQuery("from Supplier").list();
		session.close();
		return listSupplier();
	}
	
	public List<Supplier> getSupplier() {

		Session session=sessionFactory.openSession();
		List<Supplier> listSupplierDetails=(List<Supplier>)session.createQuery("from Supplier").list();
		session.close();
		return listSupplierDetails;
	}

	
}
