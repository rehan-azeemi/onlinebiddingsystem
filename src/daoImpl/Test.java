package daoImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;

import hibernate_utility.HibernateUtility;
import model.BidNotifications;
import model.Category;
import model.Notifications;
import model.PostedBidProducts;
import model.PostedBidProductsAndSellerBuyerAccount;
import model.SellerBuyerAccount;


public class Test {

	public static void main(String[] args) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
	    
		t.commit();
		s.close();
		

	}

}
