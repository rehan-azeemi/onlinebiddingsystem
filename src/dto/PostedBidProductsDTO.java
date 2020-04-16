package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Category;
import model.Images;
import model.Messages;
import model.PostedBidProductsAndSellerBuyerAccount;
import model.SellerBuyerAccount;
import model.SoldProducts;

public class PostedBidProductsDTO {
	private String postedBidProducts;
	private String category;
	private String title;
	private String minPrice;
	private String sellerBuyerAccount;
	private String sellerBuyerAccountName;
	private String description;
	private String startBid;
	private String endBid;
	List<ImagesDTO> imagesPath = new ArrayList<ImagesDTO>();
	
	public String getPostedBidProducts() {
		return postedBidProducts;
	}
	public void setPostedBidProducts(String postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getSellerBuyerAccount() {
		return sellerBuyerAccount;
	}
	public void setSellerBuyerAccount(String sellerBuyerAccount) {
		this.sellerBuyerAccount = sellerBuyerAccount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartBid() {
		return startBid;
	}
	public void setStartBid(String startBid) {
		this.startBid = startBid;
	}
	public String getEndBid() {
		return endBid;
	}
	public void setEndBid(String endBid) {
		this.endBid = endBid;
	}
	public List<ImagesDTO> getImagesPath() {
		return imagesPath;
	}
	public void setImagesPath(List<ImagesDTO> imagesPath) {
		this.imagesPath = imagesPath;
	}
	public String getSellerBuyerAccountName() {
		return sellerBuyerAccountName;
	}
	public void setSellerBuyerAccountName(String sellerBuyerAccountName) {
		this.sellerBuyerAccountName = sellerBuyerAccountName;
	}
	
}
