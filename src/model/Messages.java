package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="messages")
public class Messages {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private Integer messageId;
	
	@Column(name="message")
	private String message;
	
	@Column(name="status")
	private Integer status;

	@Column(name = "message_arrival_time", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date messageArrivalTime;
	
	@ManyToOne
	@JoinColumn(name="send_to")
	private SellerBuyerAccount sendTo;
	
	@ManyToOne
	@JoinColumn(name="send_by")
	private SellerBuyerAccount sendBy;
	
	@ManyToOne
	@JoinColumn(name="posted_bid_products_id")
	private PostedBidProducts postedBidProducts;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getMessageArrivalTime() {
		return messageArrivalTime;
	}

	public void setMessageArrivalTime(Date messageArrivalTime) {
		this.messageArrivalTime = messageArrivalTime;
	}

	public SellerBuyerAccount getSendTo() {
		return sendTo;
	}

	public void setSendTo(SellerBuyerAccount sendTo) {
		this.sendTo = sendTo;
	}

	public SellerBuyerAccount getSendBy() {
		return sendBy;
	}

	public void setSendBy(SellerBuyerAccount sendBy) {
		this.sendBy = sendBy;
	}

	public PostedBidProducts getPostedBidProducts() {
		return postedBidProducts;
	}

	public void setPostedBidProducts(PostedBidProducts postedBidProducts) {
		this.postedBidProducts = postedBidProducts;
	}
	
	
	
	
}
