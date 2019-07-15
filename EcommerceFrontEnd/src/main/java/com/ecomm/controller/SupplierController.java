package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> listSuppliers=supplierDAO.getSupplier();
		m.addAttribute("supplierList", listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/insertSupplier",method=RequestMethod.POST)
	public String addsupplier(@RequestParam("supplierName")String supplierName,@RequestParam("supplierDesc") String supplierDesc,Model m)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSupplier();
		m.addAttribute("supplierList", listSuppliers);
		
		return "Supplier";
	}
	
	
	@RequestMapping("/UpdateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		
		List<Supplier> listSuppliers=supplierDAO.getSupplier();
		m.addAttribute("supplierList",listSuppliers);
		m.addAttribute("supplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplierInDB(@RequestParam("supplierId") int supplierId,@RequestParam("supplierName") String supplierName,
			@RequestParam("supplierDesc") String supplierDesc,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSupplier();
		m.addAttribute("supplierList",listSuppliers);
		
		return "Supplier";
	}
	

	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		Supplier supplierN=new Supplier();
		m.addAttribute("supplier",supplierN);
	
		List<Supplier> listsuppliers=supplierDAO.getSupplier();
		m.addAttribute("supplierList",listsuppliers);
		return "Supplier";
	}


}
