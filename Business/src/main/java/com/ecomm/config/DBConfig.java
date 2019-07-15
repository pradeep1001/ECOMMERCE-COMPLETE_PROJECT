package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.CartDAOImpl;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.CategoryDAOImpl;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.OrderDAOImpl;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.ProductDAOImpl;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.dao.SupplierDAOImpl;
import com.ecomm.dao.UserDetailDAO;
import com.ecomm.dao.UserDetailDAOImpl;
import com.ecomm.model.Cart;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.UserDetail;

@Configuration
@ComponentScan("com.ecomm")
@EnableTransactionManagement
public class DBConfig
{
	
	
// create a datasource object
	@Bean(name="dataSource")
public DataSource getH2DataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUsername("sa");
	dataSource.setPassword("sa");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test2");
	System.out.println("=====create a datasource object===========");
	return dataSource;
}

	
	//create a session factory object
	
	
    @Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
    	//System.out.println("Hibernate properties");
	Properties hibernateProperties=new Properties();
	
	hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	hibernateProperties.put("hibernate.show_sql", "true");
	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	//System.out.println("Hibernate properties created");

	LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
	factory1.addProperties(hibernateProperties);
	//System.out.println("Factory builder object created");
	
	factory1.addAnnotatedClass(Category.class);
	factory1.addAnnotatedClass(Product.class);
	factory1.addAnnotatedClass(Supplier.class);
	factory1.addAnnotatedClass(UserDetail.class);
	factory1.addAnnotatedClass(Cart.class);
	factory1.addAnnotatedClass(OrderDetail.class);

	
	SessionFactory sessionFactory=factory1.buildSessionFactory();
	System.out.println("Session factory object created");
	return sessionFactory;
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
     
    
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}

	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("----supplier  DAO Implementation---");
		return new SupplierDAOImpl();
	}
	
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}
	
	

	@Bean(name="userDAO")
	public UserDetailDAO getUserDetailDAO()
	{
		System.out.println("----User DAO Implementation---");
		return new UserDetailDAOImpl();
	}
	
	

	
	@Bean(name="cartDAO")
	public  CartDAO getCartItemDAO()
	{
		System.out.println("----Cart  DAO Implementation---");
		return new CartDAOImpl();
	}
	
	@Bean(name="orderDAO")
	public  OrderDAO getOrderDetailDAO()
	{
		System.out.println("----Cart  DAO Implementation---");
		return new OrderDAOImpl();
	}
	
	
// create a hibernate transaction manager
	
	
	
}