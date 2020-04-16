package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dao.NotificationsDao;
import hibernate_utility.HibernateUtility;
import model.BidNotifications;
import model.Notifications;
import model.PostedBidProducts;
import model.PostedBidProductsAndSellerBuyerAccount;
import model.SellerBuyerAccount;

public class NotificationsDaoImpl implements NotificationsDao{
	@Override
	public Boolean sendNotificationToAllUsers(Notifications notifications){
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Criteria crit = session.createCriteria(PostedBidProductsAndSellerBuyerAccount.class);
		crit.add(Restrictions.eq("postedBidProducts", notifications.getPostedBidProducts()));
		crit.setProjection(Projections.property("sellerBuyerAccount"));
		List<SellerBuyerAccount> list = crit.list();
		
		ArrayList<BidNotifications> bidNotificationsList = new ArrayList<>();
		
		BidNotifications bidNotifications = null;
		
		for(int i=0; i<list.size(); i++){
			
			if(notifications.getSellerBuyerAccount().getSbaId() != list.get(i).getSbaId()){
				bidNotifications = new BidNotifications();
				bidNotifications.setSellerBuyerAccount(list.get(i));
				bidNotifications.setStatus(0);
				bidNotifications.setNotify(0);
				bidNotificationsList.add(bidNotifications);
			}
			
			
		}
		
		Criteria crit2 = session.createCriteria(PostedBidProducts.class);
		crit2.add(Restrictions.eq("postedBidProducts", notifications.getPostedBidProducts().getPostedBidProducts()));
		crit2.setProjection(Projections.property("sellerBuyerAccount"));
		List<SellerBuyerAccount> list2 = crit2.list();
		
		bidNotifications = new BidNotifications();
		bidNotifications.setSellerBuyerAccount(list2.get(0));
		bidNotifications.setStatus(0);
		bidNotifications.setNotify(0);
		
		bidNotificationsList.add(bidNotifications);
		
		notifications.setBidNotificationsList(bidNotificationsList);
		
		session.save(notifications);
		t.commit();
		session.close();
		
		return true;
	}
	
	public List<BidNotifications> getAllUnNotifyNotifications(SellerBuyerAccount sellerBuyerAccount){
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(BidNotifications.class);
		crit.add(Restrictions.eq("sellerBuyerAccount",sellerBuyerAccount));
		crit.add(Restrictions.eq("notify", 0));
		List<BidNotifications> list = crit.list();
		
		t.commit();
		s.close();
		
		return list;
	}
	
	public void updateNotifications(Integer bidNotificationId){
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		 Query query = s.createQuery("update BidNotifications set notify = :notify where bidNotificationId = :bidNotificationId");
	     query.setInteger("notify", 1);
		 query.setInteger("bidNotificationId", bidNotificationId);
		 int result = query.executeUpdate();
		 
		t.commit();
		s.close();
	}
}
