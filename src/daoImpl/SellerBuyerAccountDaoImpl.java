package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dao.SellerBuyerAccountDao;
import hibernate_utility.HibernateUtility;
import model.Messages;
import model.SellerBuyerAccount;

public class SellerBuyerAccountDaoImpl implements SellerBuyerAccountDao{

	@Override
	public SellerBuyerAccount checkLogin(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(SellerBuyerAccount.class);

	    crit.add(Restrictions.eq("email", sellerBuyerAccount.getEmail()));
	    crit.add(Restrictions.eq("password", sellerBuyerAccount.getPassword()));
	    
	    List<SellerBuyerAccount> results = crit.list();

	    if(!results.isEmpty()){
	    	t.commit();
	    	s.close();
		   
	    	return results.get(0);
	    }
	    t.commit();
	    s.close();
	    
	    
		return null;
	}

	@Override
	public Boolean registeration(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		sellerBuyerAccount.setActive(1);
		s.save(sellerBuyerAccount);
		t.commit();
		s.close();
		return true;
	}

	@Override
	public Boolean emailVerification(SellerBuyerAccount sellerBuyerAccount) {
		// TODO Auto-generated method stub
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Criteria crit = s.createCriteria(SellerBuyerAccount.class);

	    crit.add(Restrictions.eq("email", sellerBuyerAccount.getEmail()));
	    
	    List<SellerBuyerAccount> results = crit.list();

	    if(results.isEmpty()){
	    	t.commit();
	    	s.close();
		   
	    	return true;
	    }
	    t.commit();
	    s.close();

		return false;
	}

	@Override
	public void disableAccount(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		sellerBuyerAccount.setActive(0);
		s.update(sellerBuyerAccount);
		t.commit();
		s.close();
	}

	public SellerBuyerAccount checkPasswordRecovery(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(SellerBuyerAccount.class);

	    crit.add(Restrictions.eq("email", sellerBuyerAccount.getEmail()));
	    crit.add(Restrictions.eq("question", sellerBuyerAccount.getQuestion()));
	    crit.add(Restrictions.eq("answer", sellerBuyerAccount.getAnswer()));
	    
	    List<SellerBuyerAccount> results = crit.list();

	    if(!results.isEmpty()){
	    	t.commit();
	    	s.close();
		   
	    	return results.get(0);
	    }
	    t.commit();
	    s.close();
	    
	    
		return null;
	}

	@Override
	public int updatePassword(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Query query = s.createQuery("update SellerBuyerAccount set password =:Password where email =:Email ");
		query.setString("Password", sellerBuyerAccount.getPassword());
		query.setString("Email", sellerBuyerAccount.getEmail());
		
		int result = query.executeUpdate();
		
	    t.commit();
	    s.close();
	    
	    return result;
		
	}

	@Override
	public SellerBuyerAccount checkOldPassword(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(SellerBuyerAccount.class);

	    crit.add(Restrictions.eq("email", sellerBuyerAccount.getEmail()));
	    crit.add(Restrictions.eq("password", sellerBuyerAccount.getPassword()));
	    
	    List<SellerBuyerAccount> results = crit.list();

	    if(!results.isEmpty()){
	    	t.commit();
	    	s.close();
		   
	    	return results.get(0);
	    }
	    t.commit();
	    s.close();
		return null;
	}

	@Override
	public List<model.Messages> getAllUsers(SellerBuyerAccount sellerBuyerAccount) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Query q=s.createQuery("from Messages m left outer join fetch m.postedBidProducts p left outer join fetch m.sendTo s left outer join fetch m.sendBy b where m.sendTo=:SendTo group by b");
		q.setInteger("SendTo", sellerBuyerAccount.getSbaId());
		List<Messages> sendersList = q.list();
		
		t.commit();
	    s.close();
		return sendersList;
	}
	
}
