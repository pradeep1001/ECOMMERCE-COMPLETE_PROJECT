package com.ecomm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderId;
	
	String userName;
	Date orderDate;
    int totalShippingAmount;
	String pmode;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalShippingAmount() {
		return totalShippingAmount;
	}
	public void setTotalShippingAmount(int totalShippingAmount) {
		this.totalShippingAmount = totalShippingAmount;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	
	
}
