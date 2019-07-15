package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/product")
	public String showProductPage(Model m)
	{
      Product product=new Product();
      m.addAttribute(product);
      
      List<Product> productList=productDAO.listProducts();
      m.addAttribute("productList",productList);
      
      List<Category> listCategory=categoryDAO.listCategories();
      m.addAttribute("categoryList",this.categoryDetailGeneration(listCategory));
      
      return "Product";
	}
	
	@RequestMapping(value="/categoryWise/{categoryId}")
    public String categoryWiseProducts(@PathVariable("categoryId")int categoryId,Model m)
    {
		List<Product> productList=productDAO.listProductsCategoryWise(categoryId);
		m.addAttribute("productList",productList);
		
	  return "ProductDisplay";
			 
    }
	
	@RequestMapping(value="/insertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("Product")Product product,@RequestParam("pimage") MultipartFile pimage,Model m,BindingResult bindingResult)
	{
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Desc:"+product.getProductDesc());
		
		productDAO.addProduct(product);
      
		 Product product1=new Product();
		 m.addAttribute(product1);
		 
		 List<Product> productList=productDAO.listProducts();
			m.addAttribute("productList",productList);
			
		 //adding the image 
			 String path="E:\\project1\\EcommerceFrontEnd\\src\\main\\resources\\images";
		      path=path+String.valueOf(product.getProductid())+".jpg";
		      File imageFile = new File(path);
			
		      if(pimage.isEmpty())
		      {
		    	  
		    	  try
					{
						byte[] buffer=pimage.getBytes();
						FileOutputStream fos=new FileOutputStream(imageFile);
						BufferedOutputStream bs=new BufferedOutputStream(fos);
						bs.write(buffer);
						bs.close();
					}
					catch(Exception e)
					{
						System.out.println("Exception occured"+e);
						
					}
		      }
		      else
		      {
		    	  System.out.println("File is Empty");
		      }
			
			//completing the image adding
			List<Category> listCategories=categoryDAO.listCategories();
			m.addAttribute("categoryList",this.categoryDetailGeneration(listCategories));
			
			
			
		return "Product";	
	}
	
	@RequestMapping(value="/productDisplay")
	public String showProductsPage(Model m)
	{
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/totalProductDisplay/{productid}")
	public String showTotalProductInfo(@PathVariable("productid")int productid,Model m)
	{
		Product product = productDAO.getProduct(productid);
		m.addAttribute("product",product);
		
	    return "TotalProductDisplay" ;
	}
	
	@RequestMapping(value="/editProduct/{productid}")
	public String editproduct(@PathVariable(value="productid")int productid,Model m)
	{
		Product tempproduct = productDAO.getProduct(productid);
		m.addAttribute(tempproduct);
		
        return "Product";
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m,BindingResult resultset)
	{
		System.out.println("Product Name:"+product.getProductName());
		System.out.println("Product Desc:"+product.getProductDesc());
		
		productDAO.updateProduct(product);
		
		Product product1 = new Product();
		m.addAttribute(product1);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("categoryList", productList);
		
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
   public String deleteProduct(@PathVariable(value="productid")int productid,Model m)
	{
		Product tempproduct=productDAO.getProduct(productid);
		productDAO.deleteProduct(tempproduct);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
	
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
	
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> categoryDetailGeneration(List<Category> listCategories)
	{
		LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
		int count =0;
		while(count<listCategories.size())
		{
			Category category= listCategories.get(count);
			
			categoryList.put(category.getCategoryId(),category.getCategoryName());
			
			count++;
		}
		return categoryList;
	}
	
	
}