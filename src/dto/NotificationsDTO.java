package dto;



public class NotificationsDTO {
	private String notificationId;
	private String postedBidProducts;
	private String sellerBuyerAccount;
	private String notification;
	private String notificationTime;
	private String bidNotificationId;
	
	public String getBidNotificationId() {
		return bidNotificationId;
	}
	public void setBidNotificationId(String bidNotificationId) {
		this.bidNotificationId = bidNotificationId;
	}
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public String getPostedBidProducts() {
		return postedBidProducts;
	}
	public void setPostedBidProducts(String postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}
	public String getSellerBuyerAccount() {
		return sellerBuyerAccount;
	}
	public void setSellerBuyerAccount(String sellerBuyerAccount) {
		this.sellerBuyerAccount = sellerBuyerAccount;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getNotificationTime() {
		return notificationTime;
	}
	public void setNotificationTime(String notificationTime) {
		this.notificationTime = notificationTime;
	}
	
}
