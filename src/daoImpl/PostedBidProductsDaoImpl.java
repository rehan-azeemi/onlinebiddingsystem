package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import model.PostedBidProducts;
import dao.PostedBidProductsDao;
import hibernate_utility.HibernateUtility;
import model.Category;

public class PostedBidProductsDaoImpl implements PostedBidProductsDao{

	@Override
	public List<Category> getAllCategories() {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(Category.class);
	    
	    List<Category> categories = crit.list();

	    if(!categories.isEmpty()){
	    	t.commit();
	    	s.close();
		   
	    	return categories;
	    }
	    t.commit();
	    s.close();
		return null;
	}

	@Override
	public Boolean addPostedBidProduct(PostedBidProducts postedBidProducts) {
		
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		s.save(postedBidProducts);
		
		t.commit();
		s.close();
		
		return true;
	}

	@Override
	public List<PostedBidProducts> getAllPostedBidProducts() {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(PostedBidProducts.class);
		crit.setMaxResults(6);
		crit.addOrder(Order.desc("postedBidProducts"));
		List<PostedBidProducts> list = crit.list();
		
		if(!list.isEmpty()){
			t.commit();
			s.close();
			return list;
			
		}
		
		t.commit();
		s.close();
		
		return null;
		
		
	}

	@Override
	public PostedBidProducts getPostedBidProductsWithId(PostedBidProducts postedBidProducts) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		PostedBidProducts postedBidProduct = (PostedBidProducts) s.get(PostedBidProducts.class, postedBidProducts.getPostedBidProducts());
				
		t.commit();
		s.close();
				
		if(postedBidProduct != null){
			return postedBidProduct;
		}
		
		return null;
	}

}
