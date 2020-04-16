package hibernate_utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	private static SessionFactory sf = null;
	
	private HibernateUtility(){
		
	}
	
	public static SessionFactory getSessionFactory(){
		
		if(sf == null){
			Configuration cfg = new Configuration().configure();
			sf = cfg.buildSessionFactory();
		}
		
		
		return sf;
	}
}
