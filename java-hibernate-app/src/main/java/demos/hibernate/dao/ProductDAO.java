package demos.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import demos.hibernate.entity.Product;
import demos.hibernate.util.HibernateUtil;

public class ProductDAO {

	private SessionFactory factory;

	public ProductDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public int saveProduct(Product product) {
		//SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.openSession();
		Transaction s1Tx1 = s1.getTransaction();
		s1Tx1.begin();
		s1.persist(product);
		s1Tx1.commit();
		return product.getId();
	}
	
	public List<Product> getAllProducts() {
		//SessionFactory factory = HibernateUtil.getSessionFactory();
		Session s1 = factory.openSession();
		Transaction s1Tx1 = s1.getTransaction();
		s1Tx1.begin();
		
		String hql = "FROM Product";
		Query<Product> query = s1.createQuery(hql, Product.class);
		List<Product> products = query.list();
		s1Tx1.commit();
		return products;
		
	}

}
