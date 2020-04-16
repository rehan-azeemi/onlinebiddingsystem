package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="seller_buyer_account")
public class SellerBuyerAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seller_buyer_id")
	private Integer sbaId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;

	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="security_question")
	private String question;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="address")
	private String address;
	
	@Column(name="security_question_answer")
	private String answer;
	
//	@Column(name="logged_status")
//	private String loggedStatus;
	
//	public String getLoggedStatus() {
//		return loggedStatus;
//	}
//
//	public void setLoggedStatus(String loggedStatus) {
//		this.loggedStatus = loggedStatus;
//	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="sellerBuyerAccount")
	List<SoldProducts> soldProducts = new ArrayList<SoldProducts>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sellerBuyerAccount")
	List<PostedBidProducts> postedBidProducts = new ArrayList<PostedBidProducts>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sellerBuyerAccount")
	List<PostedBidProductsAndSellerBuyerAccount> productAccount = new ArrayList<PostedBidProductsAndSellerBuyerAccount>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sendTo")
	List<Messages> sendToList = new ArrayList<Messages>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sendBy")
	List<Messages> sendByList = new ArrayList<Messages>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sellerBuyerAccount")
	List<Notifications> NotificationsList = new ArrayList<Notifications>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sellerBuyerAccount")
	List<BidNotifications> BidNotificationsList = new ArrayList<BidNotifications>();
	
	public List<BidNotifications> getBidNotificationsList() {
		return BidNotificationsList;
	}

	public void setBidNotificationsList(List<BidNotifications> bidNotificationsList) {
		BidNotificationsList = bidNotificationsList;
	}

	public List<Notifications> getNotificationsList() {
		return NotificationsList;
	}

	public void setNotificationsList(List<Notifications> notificationsList) {
		NotificationsList = notificationsList;
	}

	@Column(name="active")
	private Integer active;
	
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public List<PostedBidProductsAndSellerBuyerAccount> getProductAccount() {
		return productAccount;
	}

	public void setProductAccount(List<PostedBidProductsAndSellerBuyerAccount> productAccount) {
		this.productAccount = productAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SoldProducts> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(List<SoldProducts> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public List<PostedBidProducts> getPostedBidProducts() {
		return postedBidProducts;
	}

	public void setPostedBidProducts(List<PostedBidProducts> postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}

	public Integer getSbaId() {
		return sbaId;
	}

	public void setSbaId(Integer sbaId) {
		this.sbaId = sbaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Messages> getSendToList() {
		return sendToList;
	}

	public void setSendToList(List<Messages> sendToList) {
		this.sendToList = sendToList;
	}

	public List<Messages> getSendByList() {
		return sendByList;
	}

	public void setSendByList(List<Messages> sendByList) {
		this.sendByList = sendByList;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
