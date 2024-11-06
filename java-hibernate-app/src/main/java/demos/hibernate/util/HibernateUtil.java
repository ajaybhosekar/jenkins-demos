package demos.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demos.hibernate.entity.Product;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		//cfg = cfg.configure();
		factory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		
		return factory;
		
	}

}
