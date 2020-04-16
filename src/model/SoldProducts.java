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
@Table(name="sold_products")
public class SoldProducts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sold_products_id")
	private Integer soldProductsId;
	
	@Column(name="final_price")
	private Integer finalPrice;
	
	@ManyToOne
	@JoinColumn(name="seller_buyer_id")
	private SellerBuyerAccount sellerBuyerAccount;
	
	@ManyToOne
	@JoinColumn(name="posted_bid_products_id")
	private PostedBidProducts postedBidProducts;

	public Integer getSoldProductsId() {
		return soldProductsId;
	}

	public void setSoldProductsId(Integer soldProductsId) {
		this.soldProductsId = soldProductsId;
	}

	public Integer getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}

	public SellerBuyerAccount getSellerBuyerAccount() {
		return sellerBuyerAccount;
	}

	public void setSellerBuyerAccount(SellerBuyerAccount sellerBuyerAccount) {
		this.sellerBuyerAccount = sellerBuyerAccount;
	}

	public PostedBidProducts getPostedBidProducts() {
		return postedBidProducts;
	}

	public void setPostedBidProducts(PostedBidProducts postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}
	
	
	
}
