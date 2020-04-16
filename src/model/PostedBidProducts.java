package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="posted_bid_products")
//@Proxy(lazy=false)
public class PostedBidProducts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="posted_bid_products_id")
	private Integer postedBidProducts;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name="title")
	private String title;
	
	@Column(name="min_price")
	private Integer minPrice;
	
	@ManyToOne
	@JoinColumn(name="seller_buyer_id")
	private SellerBuyerAccount sellerBuyerAccount;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "start_bid", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startBid;
	
	@Column(name = "end_bid", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endBid;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="postedBidProducts")
	List<SoldProducts> soldProducts = new ArrayList<SoldProducts>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="postedBidProducts")
	List<PostedBidProductsAndSellerBuyerAccount> productAccount = new ArrayList<PostedBidProductsAndSellerBuyerAccount>();
	
	@JoinColumn(name="posted_bid_products_id")
	@OneToMany(cascade=CascadeType.ALL)
	List<Images> imagesPath = new ArrayList<Images>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="postedBidProducts")
	List<Messages> messagesList = new ArrayList<Messages>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="postedBidProducts")
	List<Notifications> NotificationsList = new ArrayList<Notifications>();

	public String getTitle() {
		return title;
	}

	public List<Images> getImagesPath() {
		return imagesPath;
	}

	public void setImagesPath(List<Images> imagesPath) {
		this.imagesPath = imagesPath;
	}
	
	public List<Messages> getMessagesList() {
		return messagesList;
	}

	public void setMessagesList(List<Messages> messagesList) {
		this.messagesList = messagesList;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PostedBidProductsAndSellerBuyerAccount> getProductAccount() {
		return productAccount;
	}

	public void setProductAccount(List<PostedBidProductsAndSellerBuyerAccount> productAccount) {
		this.productAccount = productAccount;
	}

	public List<SoldProducts> getSoldProducts() {
		return soldProducts;
	}

	public void setSoldProducts(List<SoldProducts> soldProducts) {
		this.soldProducts = soldProducts;
	}

	public Integer getPostedBidProducts() {
		return postedBidProducts;
	}

	public void setPostedBidProducts(Integer postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public SellerBuyerAccount getSellerBuyerAccount() {
		return sellerBuyerAccount;
	}

	public void setSellerBuyerAccount(SellerBuyerAccount sellerBuyerAccount) {
		this.sellerBuyerAccount = sellerBuyerAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartBid() {
		return startBid;
	}

	public void setStartBid(Date startBid) {
		this.startBid = startBid;
	}

	public Date getEndBid() {
		return endBid;
	}

	public void setEndBid(Date endBid) {
		this.endBid = endBid;
	}
}
