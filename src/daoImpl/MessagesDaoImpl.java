package daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.MessagesDao;
import hibernate_utility.HibernateUtility;
import model.Messages;

public class MessagesDaoImpl implements MessagesDao{

	@Override
	public List<Messages> getAllMessages(Messages messages) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Criteria crit = s.createCriteria(Messages.class);
		Criterion c = Restrictions.and(Restrictions.or(Restrictions.eq("sendBy", messages.getSendBy()), Restrictions.eq("sendBy", messages.getSendTo())),Restrictions.or(Restrictions.eq("sendTo", messages.getSendBy()), Restrictions.eq("sendTo", messages.getSendTo())));
		crit.add(c);
		crit.addOrder(Order.asc("messageArrivalTime"));
		List<Messages> list = crit.list();
		
		t.commit();
		s.close();
		return list;
	}

	@Override
	public Boolean sendMessage(Messages messages) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(messages);
		t.commit();
		s.close();
		return true;
	}
	
	

}
