package com.ecomm.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{
	@Id
	int supplierId;

	
  String supplierName;
  String supplierDesc;
public int getId() {
	return supplierId;
}
public void setId(int supplierId) {
	this.supplierId = supplierId;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public String getSupplierDesc() {
	return supplierDesc;
}
public void setSupplierDesc(String supplierDesc) {
	this.supplierDesc = supplierDesc;
}
  
	
}
