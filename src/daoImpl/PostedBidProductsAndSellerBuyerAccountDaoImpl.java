package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.PostedBidProductsAndSellerBuyerAccountDao;
import hibernate_utility.HibernateUtility;
import model.PostedBidProducts;
import model.PostedBidProductsAndSellerBuyerAccount;
import model.SellerBuyerAccount;

public class PostedBidProductsAndSellerBuyerAccountDaoImpl implements PostedBidProductsAndSellerBuyerAccountDao{

	@Override
	public List<PostedBidProductsAndSellerBuyerAccount> getPostedBidProductsAndSellerBuyerAccountWithProductId(
			PostedBidProducts postedBidProducts) {
		
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(PostedBidProductsAndSellerBuyerAccount.class);
		crit.add(Restrictions.eq("postedBidProducts", postedBidProducts));
		crit.addOrder(Order.desc("currentBid"));
		List<PostedBidProductsAndSellerBuyerAccount> list = crit.list();
		
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
	public Boolean setUpdatedPostedBidProductsAndSellerBuyerAccount(
			PostedBidProductsAndSellerBuyerAccount postedBidProductsAndSellerBuyerAccount) {
		
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(PostedBidProductsAndSellerBuyerAccount.class);
		crit.add(Restrictions.eq("postedBidProducts", postedBidProductsAndSellerBuyerAccount.getPostedBidProducts()));
		crit.add(Restrictions.eq("sellerBuyerAccount", postedBidProductsAndSellerBuyerAccount.getSellerBuyerAccount()));
		List<PostedBidProductsAndSellerBuyerAccount> list = crit.list();
		
		if(list.isEmpty()){
			s.save(postedBidProductsAndSellerBuyerAccount);
			t.commit();
			s.close();
			return true;
		}
		else{
			Integer id = list.get(0).getPostedBidProductsSellerBuyerAccountId();
			postedBidProductsAndSellerBuyerAccount.setPostedBidProductsSellerBuyerAccountId(id);
			s.merge(postedBidProductsAndSellerBuyerAccount);
			t.commit();
			s.close();
			return true;
		}
		
	}

	@Override
	public List<PostedBidProductsAndSellerBuyerAccount> getAllBidedProducts(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(PostedBidProductsAndSellerBuyerAccount.class);
		crit.add(Restrictions.eq("sellerBuyerAccount", sellerBuyerAccount));
		List<PostedBidProductsAndSellerBuyerAccount> list = crit.list();
		
		t.commit();
		s.close();
		return list;
		
	}

}
