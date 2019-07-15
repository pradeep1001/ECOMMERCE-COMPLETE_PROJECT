package com.ecomm.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;
import com.ecomm.model.Category;


public interface ProductDAO {

	public boolean addProduct(Product product );
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public  Product getProduct(int productid) ;
	public List<Product> listProducts();
    public List<Product> listProductsCategoryWise(int categoryid); 	
}
