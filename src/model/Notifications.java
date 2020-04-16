package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="notifications")
public class Notifications {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="notification_id")
	private Integer notificationId;
	
	@ManyToOne
	@JoinColumn(name="posted_bid_products_id")
	private PostedBidProducts postedBidProducts;
	
	@ManyToOne
	@JoinColumn(name="seller_buyer_id")
	private SellerBuyerAccount sellerBuyerAccount;
	
	@Column(name="notification_message")
	private String notification;
	
	@Column(name = "notification_time", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationTime;
	
	@JoinColumn(name="notification_id")
	@OneToMany(cascade=CascadeType.ALL)
	List<BidNotifications> bidNotificationsList = new ArrayList<BidNotifications>();

	public List<BidNotifications> getBidNotificationsList() {
		return bidNotificationsList;
	}

	public void setBidNotificationsList(List<BidNotifications> bidNotificationsList) {
		this.bidNotificationsList = bidNotificationsList;
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public PostedBidProducts getPostedBidProducts() {
		return postedBidProducts;
	}

	public void setPostedBidProducts(PostedBidProducts postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}

	public SellerBuyerAccount getSellerBuyerAccount() {
		return sellerBuyerAccount;
	}

	public void setSellerBuyerAccount(SellerBuyerAccount sellerBuyerAccount) {
		this.sellerBuyerAccount = sellerBuyerAccount;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Date getNotificationTime() {
		return notificationTime;
	}

	public void setNotificationTime(Date notificationTime) {
		this.notificationTime = notificationTime;
	}
	
	
}
