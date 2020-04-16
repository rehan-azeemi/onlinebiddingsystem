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
@Table(name="images")
public class Images {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="images_id")
	private Integer imagesId;
	
	@Column(name="path")
	private String path;
	
	@ManyToOne
	@JoinColumn(name="posted_bid_products_id")
	private PostedBidProducts postedBidProducts;

	public Integer getImagesId() {
		return imagesId;
	}

	public void setImagesId(Integer imagesId) {
		this.imagesId = imagesId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PostedBidProducts getPostedBidProducts() {
		return postedBidProducts;
	}

	public void setPostedBidProducts(PostedBidProducts postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}
}
