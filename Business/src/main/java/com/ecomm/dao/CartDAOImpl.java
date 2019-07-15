package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	 @Autowired
	  SessionFactory sessionFactory;
	  
	
		
	    
		public boolean addCartItem(Cart cartItem) {
			try
			{
				sessionFactory.getCurrentSession().save(cartItem);
				return true;
			}
			catch(Exception e)
			{
			return false;
		   }
		}

		public boolean deleteCartItem(Cart cart) {
			try
			{
				sessionFactory.getCurrentSession().delete(cart);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
			
		}

		public boolean updateCartItem(Cart cart) {
			try
			{
				sessionFactory.getCurrentSession().update(cart);
				return true;
			}
			catch(Exception e)
			{
			return false;
		}
		}

		public List<Cart> listCartItems(String username) {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:uname and Status='NP'");
			query.setParameter("uname",username);
			List<Cart> listCartItems=query.list();
			session.close();
			return listCartItems;
		}
		

		public Cart getCartItem(int cartItemId) {
			Session session=sessionFactory.openSession();
			Cart cart=(Cart)session.get(Cart.class,cartItemId);
			session.close();
			return cart;
		}
		
		
}
