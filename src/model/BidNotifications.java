package model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bid_notifications")
public class BidNotifications {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bid_notification_id")
	private Integer bidNotificationId;
	
	@ManyToOne
	@JoinColumn(name="notification_id")
	private Notifications notificationId;
	
	@ManyToOne
	@JoinColumn(name="seller_buyer_id")
	private SellerBuyerAccount sellerBuyerAccount;
	
	@Column(name="status")
	private Integer status;

	@Column(name="notify")
	private Integer notify;

	public Integer getNotify() {
		return notify;
	}

	public void setNotify(Integer notify) {
		this.notify = notify;
	}

	public SellerBuyerAccount getSellerBuyerAccount() {
		return sellerBuyerAccount;
	}

	public void setSellerBuyerAccount(SellerBuyerAccount sellerBuyerAccount) {
		this.sellerBuyerAccount = sellerBuyerAccount;
	}

	public Integer getBidNotificationId() {
		return bidNotificationId;
	}

	public void setBidNotificationId(Integer bidNotificationId) {
		this.bidNotificationId = bidNotificationId;
	}

	public Notifications getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Notifications notificationId) {
		this.notificationId = notificationId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
}
