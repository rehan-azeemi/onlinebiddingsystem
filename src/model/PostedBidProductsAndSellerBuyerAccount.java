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
@Table(name="posted_bid_products_seller_buyer_account")
public class PostedBidProductsAndSellerBuyerAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="posted_bid_products_seller_buyer_account_id")
	private Integer postedBidProductsSellerBuyerAccountId;
	
	@ManyToOne
	@JoinColumn(name="posted_bid_products_id")
	private PostedBidProducts postedBidProducts;
	
	@ManyToOne
	@JoinColumn(name="seller_buyer_id")
	private SellerBuyerAccount sellerBuyerAccount;
	
	@Column(name="current_bid")
	private Integer currentBid;

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

	public Integer getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Integer currentBid) {
		this.currentBid = currentBid;
	}

	public Integer getPostedBidProductsSellerBuyerAccountId() {
		return postedBidProductsSellerBuyerAccountId;
	}

	public void setPostedBidProductsSellerBuyerAccountId(Integer postedBidProductsSellerBuyerAccountId) {
		this.postedBidProductsSellerBuyerAccountId = postedBidProductsSellerBuyerAccountId;
	}
	
	
}
